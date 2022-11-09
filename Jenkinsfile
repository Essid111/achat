pipeline {
    agent any
     tools {
        maven'Maven2'
    }
    stages {
        
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
	stage('MVN Test') { 
            steps {
                 sh 'mvn test'
            }
        }
	stage('Package') {
                      steps {
                           sh "mvn package -DskipTests=true"
                    }
          }
	stage('Sonar') {
            steps {
                 sh "mvn sonar:sonar"
          }
        }
        

        }
}
