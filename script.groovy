def cloneGit() {
    echo 'clone git repository '
    git credentialsId: 'github_user', url: 'https://github.com/mvm283/starter_project_product_spring.git'
     withMaven {
      sh "mvn clean verify"
    }
} 
def buildApp() {
    echo 'buildApp '
    bat 'mvn clean build'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this
