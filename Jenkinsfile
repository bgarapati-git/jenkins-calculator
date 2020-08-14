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
				script{
					withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USER_NAME')]) {
					    bat "docker login -u $USER_NAME -p $PASSWORD"
					}
				}
				echo "login success"
				
				bat "docker build -t $USER_NAME/jenkins-calculator:$BUILD_NUMBER -f Dockerfile ."
				success {
					echo "docker build succeeded"
					bat "docker push"
				}
			}
		}	
	
		
	}
}
