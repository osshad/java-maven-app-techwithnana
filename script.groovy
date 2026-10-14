def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t {PRIVATE_REPO}:{IMAGE_TAG} .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push {PRIVATE_REPO}:{IMAGE_TAG}'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
