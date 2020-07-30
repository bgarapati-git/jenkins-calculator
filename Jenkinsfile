pipeline{
	agent any
	stages{
		stage('preparation'){
			steps{
				//git 'https://github.com/bgarapati-git/jenkins-calculator.git'
				echo "preparation step started and completed"
			}
		}
		stage('build'){
			steps{
				bat "mvn clean test"
			}
		}
		stage('package'){
			steps{
				bat "mvn package"
			}
			post {
				always {
					junit '**/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}
			}			
		}
		
	}
}
