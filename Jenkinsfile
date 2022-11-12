pipeline {
    agent any
    
 options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-token')
    }

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
          
    stage('MVN PACKAGE') {
            steps {
                sh 'mvn -DskipTests clean package' 
            }
        }
   stage('Build Docker Image') {
            steps {
                sh 'docker build -t zahraabassi/achat .'
            }
        } 

       stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "Docker-Hub-zahraabassi", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t zahraabassi/achat:latest .'
           sh 'docker push zahraabassi/achat:latest '
         }
       }
     }
    }

}





