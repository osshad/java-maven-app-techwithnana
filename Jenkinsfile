pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {
        stage('test') {
            steps {
                echo 'Testing the application...'
                echo "Branch name: ${env.GIT_BRANCH}"
            }
        }

        stage('build') {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/master' ||
                    env.GIT_BRANCH == 'master'
                }
            }
            steps {
                echo 'Building the application...'
            }
        }

        stage('deploy') {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/master' ||
                    env.GIT_BRANCH == 'master'
                }
            }
            steps {
                echo 'Deploying Docker image...'
            }
        }
    }
}
