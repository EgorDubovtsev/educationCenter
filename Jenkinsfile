pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {
                bat "mvn clean package"
            }
        }
    }
}
