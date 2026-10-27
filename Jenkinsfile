#!/user/bin/env groovy

library identifier: "jenkins-shared-library@starting-code", retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'https://github.com/osshad/jenkins-shared-library.git'
     ]
)

def gv

pipeline {   
    agent any
    tools {
        maven 'maven-3.10'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("increment version") {
            steps {
                script {
                    env.IMAGE_NAME=incrementVersion()
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                        buildJar()
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    dockerLogin()
                    buildImage 'olushad/demo-app:jma-3.0'
                    dockerPush 'olushad/demo-app:jma-3.0'
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
} 
