pipeline {
    agent any

	environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.43.248:8081"
        NEXUS_REPOSITORY = "chayma-nexus-repo"
        NEXUS_CREDENTIAL_ID = "Nexus"
    }

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
	/*stage('Sonar') {
            steps {
              
                sh 'mvn clean package sonar:sonar'
		echo 'sonar validé'
              
            }
        }*/
	stage("Nexus ") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
			echo 'nexus validé'
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }
        
	stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "my-docker-hub", url: ""]) {
           sh 'printenv'
           sh 'docker build -t chaymaguesmi/achat:latest .'
           sh 'docker push chaymaguesmi/achat:latest '
         }
       }
     }
	 stage('Run app with Docker Compose') {
       steps {
               sh 'docker-compose up --d --force-recreate '
       }
     }

	
	stage('Email Notifications'){
                 steps{
                 mail bcc: '', body: '''Hello , 
                 A Build has been executed on Your Project Achat , if you notice any bugs or abnormal behaviour please contact your team leader
                 Best Regards , 
                 Chayma Guesmi''', 
                 cc: '', from: '', replyTo: '', subject: 'A Build was executed on achat', to: 'chayma.guesmi@esprit.tn'
             
                 }
                 } 



        }
      
  

}
