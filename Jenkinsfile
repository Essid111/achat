pipeline {
    agent any
    


    stages {
        stage("GIT"){
            steps{
              
                git branch: 'ZahraAbassi', 
                credentialsId: '470a5fd233ca3c0c8fd6e45e3a00daabb256b343', 
                url: 'https://github.com/Essid111/achat.git'
                    
                }
                
            }
                    stage('MVN COMPILE') {
                steps {
                sh 'mvn clean compile'
                    
                }
                         }
                            
        stage('MVN TEST') {
            steps {
                echo 'mvn -v'
                echo 'mvn -v'
                sh 'mvn test'
            }
        }
   
}}