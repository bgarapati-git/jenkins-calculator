pipeline{
	agent any
	stages{
		stage('build and test'){
			steps{
				//bat "mvn clean install"
				echo "build"
			}
		}
		stage('publish test results'){
			steps{
				//junit '**/target/surefire-reports/TEST-*.xml'
				//archiveArtifacts 'target/*.jar'
				echo "Results published"
			}
		}
		stage('docker package'){
			environment{
				USERNAME = ""
			}
			
			steps{
				script{
					withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USER_NAME')]) {
					    bat "docker login -u $USER_NAME -p $PASSWORD"
						$USERNAME = "$USER_NAME"
					}
				}
				echo "login success"
				
				bat "docker build -t $USERNAME/jenkins-calculator:$BUILD_NUMBER -f Dockerfile ."
				success {
					echo "docker build succeeded"
					bat "docker push"
				}
			}
		}	
	
		
	}
}
