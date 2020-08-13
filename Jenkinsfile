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
			steps{
				echo "create docker image"
			}
		}	
		stage('Deploy container in Kubernetes'){
			steps{
				echo "deploy in kubernetes"
			}
		}		
		
	}
}
