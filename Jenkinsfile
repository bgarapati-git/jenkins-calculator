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
				dockerRepositoryUrl = "bgrapati/jenkins-calculator"
			}
			
			steps{
				script{
					withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USRNAME')]) {
						bat "docker login -u $USRNAME -p $PASSWORD"
						def USER_ID = '${USRNAME}'
					}
				}
				
				echo "login success ${USER_ID}"
				
				bat "docker build -t $dockerRepositoryUrl:$BUILD_NUMBER -f Dockerfile ."
				echo "docker build succeeded"
				bat "docker push $dockerRepositoryUrl:$BUILD_NUMBER"
			}
		}	
	
		
	}
}
