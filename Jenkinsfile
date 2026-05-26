pipeline {

    agent any

    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-creds'
        DOCKERHUB_USERNAME = 'ashishranjanyadav'

        USER_IMAGE = "${DOCKERHUB_USERNAME}/user-service"
        BOOK_IMAGE = "${DOCKERHUB_USERNAME}/book-service"
        ORDER_IMAGE = "${DOCKERHUB_USERNAME}/order-service"

        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    tools {
        jdk 'jdk21'
	maven 'maven'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main',
                url: 'https://github.com/AshishRanjanMCA/Book-store-microservice-project.git'
            }
        }

        stage('Build User Service') {
            steps {
                dir('user-service') {
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Build Book Service') {
            steps {
                dir('book-service') {
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Build Order Service') {
            steps {
                dir('order-service') {
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {

                sh """
                docker build -t ${USER_IMAGE}:${IMAGE_TAG} ./user-service
                docker build -t ${BOOK_IMAGE}:${IMAGE_TAG} ./book-service
                docker build -t ${ORDER_IMAGE}:${IMAGE_TAG} ./order-service
                """
            }
        }

        stage('Trivy Security Scan') {
            steps {

                sh """
                trivy image ${USER_IMAGE}:${IMAGE_TAG}
                trivy image ${BOOK_IMAGE}:${IMAGE_TAG}
                trivy image ${ORDER_IMAGE}:${IMAGE_TAG}
                """
            }
        }

        stage('DockerHub Login') {
            steps {

                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS}",
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Images') {
            steps {

                sh """
                docker push ${USER_IMAGE}:${IMAGE_TAG}
                docker push ${BOOK_IMAGE}:${IMAGE_TAG}
                docker push ${ORDER_IMAGE}:${IMAGE_TAG}
                """
            }
        }

        stage('Deploy Application') {
            steps {

                sh """
                docker compose down
                docker compose up -d --build
                """
            }
        }

        stage('Cleanup Old Images') {
            steps {

                sh 'docker image prune -f'
            }
        }
    }

    post {

        success {
            echo 'Application deployed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}
