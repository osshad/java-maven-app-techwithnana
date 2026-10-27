pipeline {
    agent any

    triggers {
        pollSCM('H/2 * * * *')
    }

    stages {
        stage('test') {
            steps {
                echo 'Testing the application...'
                echo "Branch name: ${env.GIT_BRANCH}"
                echo 'New changes added'
            }
        }

        stage('build') {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/single_pipeline_branch' ||
                    env.GIT_BRANCH == 'single_pipeline_branch'
                }
            }
            steps {
                echo 'Building the application...'
            }
        }

        stage('deploy') {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/single_pipeline_branch' ||
                    env.GIT_BRANCH == 'single_pipeline_branch'
                }
            }
            steps {
                echo 'Deploying Docker image...'
            }
        }
    }
}
