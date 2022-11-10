pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS=credentials('DockerHub')
    }

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
        stage('clean'){
                steps{
                sh 'mvn clean package'
                    
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

        stage("Building image") {
            steps {
                sh 'docker build -t ZahraAbassi/Facture . '
            }
        }
        stage('Docker Login') {

			steps {
				sh 'echo $DockerHub_CREDENTIALS_PSW | docker login -u ZahraAbassi -p Zahrabassi docker.io'
			}
		} 
        stage('Push') {

			steps {
				sh 'docker push ZahraAbassi/Facture'
			}
	}
		stage('deploy docker-compose'){
            steps{
                script{
                    sh 'docker-compose up -d'
                }
            }
       
        }   
   
	
       
    }

} 