pipeline {
    agent any
    tools {
        maven 'maven-3.10'
    }
    stages {
        stage("build jar") {
            steps {
                echo 'building the application...'
                sh 'mvn package'
            }
        }
        stage("build image") {
            steps {
                echo 'building the docker image...'
                withCredentials([
                    usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')
                ]) {
                    sh 'docker build -t olushad/demo-app:jma-2.0 .'
                    sh 'echo $PASS | docker login -u $USER --pasword-stdin'
                    sh 'docker push olushad/demo-app:jma-2.0'
                }
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the application...'
            }
        }
    }
}
