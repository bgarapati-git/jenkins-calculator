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
			
			steps{
				script{
					withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USRNAME')]) {
						bat "docker login -u $USRNAME -p $PASSWORD"
						def USERNAME= '${USRNAME}'
					}
				}
				echo "login success ${USERNAME}"
				
				bat "docker build -t $USERNAME/jenkins-calculator:$BUILD_NUMBER -f Dockerfile ."
				success {
					echo "docker build succeeded"
					bat "docker push"
				}
			}
		}	
	
		
	}
}
