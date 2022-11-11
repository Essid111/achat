pipeline {
    agent any
    


    stages {
        stage("git pull"){
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
             stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "Docker-Hub-zahraabassi", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t zahraabassi/ci:latest .'
           sh 'docker push zahraabassi/ci:latest '
         }
       }
     }
        stage('clean'){
                steps{
                sh 'mvn clean package'
                    
                }
                
            }  
                   stage('Unit test - Junit and jacoco') {
            steps {
              sh "mvn test"
            }

	      }
        stage('MVN TEST') {
                steps {
                sh 'mvn clean test'
                    
                }
                
            }  
        stage('build'){
            steps{
                sh 'mvn install package'
            }
         }

  
       
        }   
   
	
       
    }

