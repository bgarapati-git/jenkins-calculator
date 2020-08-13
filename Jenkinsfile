pipeline{
	agent any
	stages{
		stage('build and test'){
			steps{
				bat "mvn clean install"
			}
		}
		stage('publish test results'){
			steps{
				junit '**/target/surefire-reports/TEST-*.xml'
				archiveArtifacts 'target/*.jar'
			}
		}
		stage('docker package'){
			environment{
			    registry = "bgrapati/jenkins-calculator"
			    registryCredential = "dockerhub"
			    dockerImage = ""
			}
			steps{
				script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"	
					echo dockerImage
				}
			}
		}	
		stage('Deploy container in Kubernetes'){
			steps{
				echo "deploy in kubernetes"
			}
		}		
		
	}
}
