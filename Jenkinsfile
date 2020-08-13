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
				bat "docker build -t jenkins-calculator:$BUILD_NUMBER -f Dockerfile.file"
				echo "docker package"
			}
		}	
	
		
	}
}
