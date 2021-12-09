def gv

pipeline {
    agent any
 
    stages {
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy" 
                }
            }
        }
        stage("clone git") {
           steps {
             git credentialsId: 'github_user', url: 'https://github.com/mvm283/starter_project_product_spring.git'
           }            
        }
        stage("build") {
            steps {
                bat "mvn -DskipTests=true clean compile package  -f pom.xml"
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
