// def buildJar() {
//     echo "building the application..."
//     sh 'mvn package'
// } 

// def buildImage() {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t USER_NAME/demo-app:jma-2.0 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push USER_NAME/demo-app:jma-2.0'
//     }
// } 

// def deployApp() {
//     echo 'deploying the application...'
// } 

// return this
def buildApp() {
    echo "building the application..."
}
def testApp() {
    echo "Testing the application..."
}
def deployApp() {
    echo "Deploying the application..."
    echo "Deploying version ${params.VERSION}"
}

return this