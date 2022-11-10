pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
               bat "rmdir  /s /q FactureServiceTest"
                bat "git clone https://github.com/Essid111/achat.git"
                bat "mvn clean -f FactureServiceTest"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f FactureServiceTest"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f FactureServiceTest"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f FactureServiceTest"
            }
        }
    }
}