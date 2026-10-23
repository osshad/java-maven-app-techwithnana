#!/user/bin/env groovy
@Library('jenkins-shared-library')
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
