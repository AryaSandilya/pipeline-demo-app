pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9'
        jdk 'JDK-21'
    }
    
    environment {
        APP_NAME = 'pipeline-demo-app'
        APP_VERSION = '1.0-SNAPSHOT'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo '================================================'
                echo 'Stage: Checking out code from GitHub'
                echo '================================================'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo '================================================'
                echo 'Stage: Building the application'
                echo '================================================'
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo '================================================'
                echo 'Stage: Running unit tests'
                echo '================================================'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '================================================'
                echo 'Stage: Packaging JAR file'
                echo '================================================'
                bat 'mvn package -DskipTests'
            }
        }
        
        stage('Verify') {
            steps {
                echo '================================================'
                echo 'Stage: Verifying build artifacts'
                echo '================================================'
                bat 'dir target'
            }
        }
        
        stage('Run Application') {
            steps {
                echo '================================================'
                echo 'Stage: Running the application'
                echo '================================================'
                bat "java -jar target\\%APP_NAME%-%APP_VERSION%.jar"
            }
        }
    }
    
    post {
        success {
            echo '================================================'
            echo 'Pipeline executed successfully!'
            echo '================================================'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'JAR file archived successfully'
        }
        failure {
            echo '================================================'
            echo 'Pipeline failed! Check logs for details.'
            echo '================================================'
        }
        always {
            echo '================================================'
            echo 'Cleaning up workspace'
            echo '================================================'
            cleanWs()
        }
    }
}