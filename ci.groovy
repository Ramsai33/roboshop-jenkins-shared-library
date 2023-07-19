def call() {
    pipeline {

        agent {
            label 'workstation'
        }

        stages {

            stage('Build/compile') {
                steps{
                    echo 'Build'
                }
            }

            stage('Unit Test') {
                steps{
                    echo 'Unit Test'
                }
            }

            stage('Quality control') {
                steps{
                    echo 'Quality control'
                }
            }

            stage('Uploading code to centralize place') {
                steps{
                    echo 'Uploaded'
                }
            }
        }

    }
}

