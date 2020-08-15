pipeline{
	agent any
	environment{
		USER_INFO = "environment variable"
	}
	stages{
		stage('build and test'){
			steps{
				//bat "mvn clean install"
				echo "build success"
			}
			post{
				success{
					//junit '**/target/surefire-reports/TEST-*.xml'
					//archiveArtifacts 'target/*.jar'
					echo "Results published"				
				}
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
						USER_INFO = "${USRNAME}"
						env.USER_INFO = USER_INFO + " dfsfd"
					}
				}
				
				echo "login success ${USER_INFO}"
				echo "login success ${env.USER_INFO}"
				
				bat "docker build -t $dockerRepositoryUrl:$BUILD_NUMBER -f Dockerfile ."
				bat "docker tag $dockerRepositoryUrl:$BUILD_NUMBER $dockerRepositoryUrl:latest
				bat "docker push $dockerRepositoryUrl:latest"
				bat "docker rmi $dockerRepositoryUrl:$BUILD_NUMBER $dockerRepositoryUrl:latest"
			}
		}	
		stage('deploy application'){
			steps{
				bat "kubectl config view"
				//bat "kubectl create -f jenkins-calculator_pod.yaml"
			}
		}
	
	}
}
