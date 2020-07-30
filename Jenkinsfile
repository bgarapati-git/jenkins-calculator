pipeline{
	agent any
	stages{
		stage('preparation'){
			steps{
				bat "mvn clean"
			}
		}
		stage('package'){
			steps{
				bat "mvn package"
			}
		}
		post {
			always {
				junit '**/target/surefire-reports/TEST-*.xml'
				archiveArtifacts 'target/*.jar'
			}
		}		
	}
}
