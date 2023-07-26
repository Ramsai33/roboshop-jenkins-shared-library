def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
        sh 'env'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }
}

def unittest() {
    if (app_lang == "nodejs") {
       sh 'npm test'
//        sh 'echo unittest'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }

    if (app_lang == "python") {
        sh 'echo python'
    }
}

def email(email_note) {
    mail bcc: '', body: 'Job Failure', cc: '', from: 'mudurukollaramsai333@gmail.com', replyTo: '', subject: 'Test', to: 'mudurukollaramsai333@gmail.com'
}
