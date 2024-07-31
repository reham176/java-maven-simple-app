def buildJar() {
    echo 'building the jar file'
    sh 'mvn package'
}
def buildImage() {
    echo 'building the docker image'
    withcredentials([usernamePassword(credentialsId:'dockerhub-depi', passwordVariable:'PASSWORD' , usernameVariable:'USERNAME')]){
    sh 'docker build -t rehamahmed176/my-app1:jmvn-2.0 .'
    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
    sh 'docker push rehamahmed176/my-app1:jmvn-1.0'
    }  
} 

def deployApp() {
    echo 'deploying the application....'
}

return this
