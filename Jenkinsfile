def gv

pipeline {
    agent any
   
    environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub-mohammade-cr')
	    registry = "YourDockerhubAccount/YourRepository"
	registryCredential = 'dockerhub_id'
	dockerImage = ''
	}
    stages { 
        stage("clone git") {
           steps {
             git credentialsId: 'github_user', url: 'https://github.com/mvm283/starter_project_product_spring.git'
           }            
        }
        stage("build app") {
            steps {
                bat "mvn -DskipTests=true clean compile package  -f pom.xml"
            }
        }
       stage('Building our image') {
	  steps{
		bat 'docker build -t mohammadvee/spring-appp:'+':$BUILD_NUMBER'+'.'
		}
	}
        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}
