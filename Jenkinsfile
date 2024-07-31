pipeline{
    agent any
    tools{
        maven 'maven-3.6'
    }
    stages{
        stage ('build jar') {
            steps{
                echo 'building the jar file'
                sh 'mvn package'
            }

        }
        stage('build image'){
            steps{
                echo 'building the docker image'
                withcredentials([usernamepassword(credentialsId:'dockerhub-depi', passwordVariable:'PASSWORD' , usernameVariable:'USERNAME')]){
                    sh 'docker build -t rehamahmed176/my-app1:jmvn-1.0 .'
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                    sh 'docker push rehamahmed176/my-app1:jmvn-1.0'    
                }
                sh 'docker build -t rehamahmed176/my-app1:jmvn-1.0 .'
                sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                sh 'docker push rehamahmed176/my-app1:jmvn-1.0'

            } 
        }
        stage('deploy app'){
            steps{
                echo 'deploying the application....' 
            } 
        }

        

    }
}
