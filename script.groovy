def gloneGit() {
    echo 'clone git repository '
    git credentialsId: 'github_user', url: 'https://github.com/mvm283/jenkinestest'
} 
def buildApp() {
    echo 'buildApp '
    sh 'mvn clean build'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this
