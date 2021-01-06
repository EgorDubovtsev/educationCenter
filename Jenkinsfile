pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {

                git 'https://github.com/EgorDubovtsev/educationCenter.git'

                bat "mvn clean package"


            }


        }
    }
}
