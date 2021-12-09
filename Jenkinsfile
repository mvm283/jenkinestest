def gv

pipeline {
    agent any
   
    environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub-mohammade-cr')
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
        stage("build app") {
            steps {
                bat 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                bat 'docker build -t mohammadvee/spring-app:latest .
                bat 'docker push mohammadvee/spring-app:latest'
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
