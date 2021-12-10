pipeline{ 
	
	agent any
	environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
		
	}
	 tools {
            maven 'maven3.8.4'
          }	
	def dockerHome = tool 'dockerjen'
		def mavenHome  = tool 'maven3.8.4'
		env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
	
	stages {
	    
	  
	       stage("clone git") {
		   steps {
		     sh 'docker --version'
		     git credentialsId: 'github_user', url: 'https://github.com/mvm283/starter_project_product_spring.git'
		   }            
		}
		stage("build app") {
		    steps {
			sh "mvn -DskipTests=true clean compile package  -f pom.xml"
		    }
		}
		stage('Build docker') {

			steps {
				sh 'docker build -t mohammadvee/spring-appp:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push mohammadvee/spring-appp:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
