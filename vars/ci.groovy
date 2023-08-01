def call() {
    try {
        pipeline {

            agent {
                label 'workstation'
            }

            stages {

                stage('Build/compile') {
                    steps {
                        script {
                            common.compile()
                        }
                    }
                }

                stage('Unit Test') {
                    steps {
                        script {
                            common.unittest()
                        }
                    }
                }

                stage('Quality control') {
                    steps {
                        SONAR_PASS = sh ( script: 'aws ssm get-parameters --region us-east-1 --names sonarqube.pass  --with-decryption --query Parameters[0].Value | sed \'s/"//g\'', returnStdout: true).trim()
                        SONAR_USER = sh ( script: 'aws ssm get-parameters --region us-east-1 --names sonarqube.user  --with-decryption --query Parameters[0].Value | sed \'s/"//g\'', returnStdout: true).trim()

                        sh'sonar-scanner -Dsonar.host.url=http://172.31.82.44:9000 -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASS} -Dsonar.projectKey=cart'
                    }
                }

                stage('Uploading code to centralize place') {
                    steps {
                        echo 'Uploaded'
                    }
                }
            }

        }
    }

    catch(Exception e) {
        common.email("failed")
    }

}