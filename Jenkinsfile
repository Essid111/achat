 pipeline {
    agent any
    stages {
        stage('Build Artifact - Maven') {
steps {
sh "mvn clean package -DskipTests=true"
archive 'target/*.jar'

}
}
       stage("GIT"){
            steps{
                git branch: 'ZahraAbassi', 
                credentialsId: '470a5fd233ca3c0c8fd6e45e3a00daabb256b343', 
                url: 'https://github.com/Essid111/achat.git'
                    
                }
                
            }
            stage('MVN CLEAN'){
            steps{
                sh  'mvn clean'
            } }
            
        
                    stage('MVN COMPILE') {
                steps {
                sh 'mvn clean compile'
                    
                } }
                            
        stage('Unit test') {
            steps {
                echo 'mvn -v'
                echo 'mvn -v'
                sh 'mvn test'
            }
        }
          
    stage('MVN PACKAGE') {
            steps {
               sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """ 
            }
        }
   
      stage('Docker Login') {

			steps {
				sh 'echo $DockerHub_CREDENTIALS_PSW | docker login -u zahraabassi -p espritesprit docker.io'
			}} 
			
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t zahraabassi/achat .'
            }
        } 
       
        stage('Push Docker Image') {

			steps {
				sh 'docker push zahraabassi/achat'
			}}
			  
        stage ('SonarQuality') {
		steps {
			
          sh "mvn sonar:sonar \
             -Dsonar.projectKey=achat \
  -Dsonar.host.url=http://172.10.2.140:9000 \
  -Dsonar.login=b67a911d9183014282a22c5213f41c7cacfa78d9"
		}}
          }
          
        
	 
          
          
          
          }
	 