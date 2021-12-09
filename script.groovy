def buildApp() {
    echo 'git clone '
    git url: 'https://github.com/mvm283/jenkinestest.git')
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this
