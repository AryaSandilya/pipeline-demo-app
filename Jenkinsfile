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
                echo 'Checking out: pipeline-demo-app from GitHub'
                echo '================================================'
                checkout scm
            }
        }
        
        stage('Environment Info') {
            steps {
                echo '================================================'
                echo 'Environment Information'
                echo '================================================'
                bat '''
                    echo Java Version:
                    java -version
                    echo.
                    echo Maven Version:
                    mvn -version
                    echo.
                    echo Git Version:
                    git --version
                '''
            }
        }
        
        stage('Build') {
            steps {
                echo '================================================'
                echo 'Building the application'
                echo '================================================'
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo '================================================'
                echo 'Running unit tests'
                echo '================================================'
                bat 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '================================================'
                echo 'Packaging JAR file'
                echo '================================================'
                bat 'mvn package -DskipTests'
            }
        }
        
        stage('Verify Artifacts') {
            steps {
                echo '================================================'
                echo 'Verifying build artifacts'
                echo '================================================'
                bat '''
                    echo Listing target directory:
                    dir target
                    echo.
                    echo Checking JAR file:
                    if exist "target\\pipeline-demo-app-1.0-SNAPSHOT.jar" (
                        echo JAR file found successfully!
                    ) else (
                        echo ERROR: JAR file not found!
                        exit /b 1
                    )
                '''
            }
        }
        
        stage('Run Application') {
            steps {
                echo '================================================'
                echo 'Running the application'
                echo '================================================'
                bat "java -jar target\\pipeline-demo-app-1.0-SNAPSHOT.jar"
            }
        }
    }
    
    post {
        success {
            echo '================================================'
            echo 'BUILD SUCCESSFUL!'
            echo 'Project: pipeline-demo-app'
            echo '================================================'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo '================================================'
            echo 'BUILD FAILED!'
            echo 'Check the console output for errors'
            echo '================================================'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}