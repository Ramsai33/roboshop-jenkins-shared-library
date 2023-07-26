def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }
}

def unittest() {
    if (app_lang == "nodejs") {
      //  sh 'npm test'
        sh 'echo unittest'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }

    if (app_lang == "python") {
        sh 'echo python'
    }
}

