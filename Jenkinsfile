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
