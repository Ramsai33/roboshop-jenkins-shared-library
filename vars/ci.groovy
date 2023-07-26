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
                        echo 'Quality control'
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

    catch(Build Fail) {
        common.email('failed')
    }

}