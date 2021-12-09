def cloneGit() {
    echo 'clone git repository '
   
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
    echo "deploying version  "
} 

return this
