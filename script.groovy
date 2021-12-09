def buildApp() {
    echo 'git clone '
    git {
          remote {
            url('https://github.com/mvm283/jenkinestest.git')
          }
          branch('*/master')
        } 
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this
