pipeline {
    agent any
    stages {
       stage("test") {
           steps {
               script {
                   echo "Testing the application..."
                   echo "Branch name $BRANCH_NAME"
               }
           }
       }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
           steps {
               script {
                   echo "Building the application..."
               }
           }
       }
        stage('deploy') {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    echo 'deploying docker image...'
                }
            }
        }
    }
}
