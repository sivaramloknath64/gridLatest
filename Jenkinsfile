
pipeline {
    agent any

    triggers {
        cron('H 21 * * *')
    }

    environment {
        DOCKER_COMPOSE_FILE = 'docker-compose.yaml'
        
        PROJECT_DIR = "${env.WORKSPACE}"
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
                echo "Repository cloned successfully to ${env.WORKSPACE}"
            }
        }

        stage('Prepare') {
            steps {
                bat 'docker --version'
                bat 'docker-compose --version'

                bat "docker-compose -f ${DOCKER_COMPOSE_FILE} up -d"
                bat 'docker ps'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                dir("${PROJECT_DIR}") {
                    bat "mvn clean test -P${params.Suite} -Dbrowser=${params.Browser}"
                }
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'Reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Report'
            ])

            bat(
                script: "docker-compose -f ${DOCKER_COMPOSE_FILE} down",
                returnStatus: true
            )

            echo 'ExtentReport publishing and Docker cleanup attempted.'
        }
    }
}
