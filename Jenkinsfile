pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {
                bat "mvn clean install -Pjenkins -DBUILD_NUMBER=${BUILD_NUMBER}"
                bat "mvn package"
            }
        }
    }
}
