pipeline {

	agent any
	
	tools {
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
	}
	
	stages {
	
		stage("Checkout Code") {
			steps {
			git branch: 'main',
			url: "https://github.com/pvenkatesh2291/Anon-website.git"
			}
		}
		
		stage('Building the code for .war file') {
			steps {
				sh 'java -version && mvn --version'
				sh 'mvn clean package'
			}
		}
		
		stage('Copying the .war file to new location') {
			steps {
				sh 'mv /var/lib/jenkins/workspace/2ndpipeline/webapp/target/webapp.war /tmp'
			}
		}
		
		stage('Cleaning the workspace') {
			steps {
				sh 'rm -rf /var/lib/jenkins/workspace/Pipeline_script_1/*'
			}
		}
		
	}
	
}