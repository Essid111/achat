pipeline {
    agent any
    stages {
        
        stage('Chekout Git') { 
            steps {
                 git branch:'rayen',
                 url: 'https://github.com/Essid111/achat.git'
               
            }
        }
        stage('MVN Clean') { 
            steps {
                 sh 'mvn clean'
            }
        }
        stage('MVN Compile') { 
            steps {
                 sh 'mvn compile'
            }
        }
        
        }
}
