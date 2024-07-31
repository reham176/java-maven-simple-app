pipeline{
    agent any
    tools{
        maven 'manen-3.6'
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
                echo 'building the image'
                sh 'docker build -t rehamahmed176/my-app1:jmvn-1.0'
                sh "echo $PASSWORD docker login -u $USERNAME --password-stdin"
                sh 'docker push rehamahmed176/my-app1:jmvn-1.0'

        }
        stage('deploy app'){
            steps{
                echo 'deploying the application....' 
            } 
        }

        }

    }
}
            when {
                expression {
                    params.executeTests == true //no need to use == true   //you can also use !params.executeTests
                }
            }
            steps {
                script {
                    groovyFile.testApp()
                }
            }
        }
        stage('deploy') {
            
            steps {
                script {
                    env.ENV = input message: "select an Env to deploy the application",ok: "Done", parameters: [choice(name: 'ENV01',  choices: ['DEV', 'stagging', 'prodction'], description: 'pick an first env to deploy the application to it')]
                    groovyFile.deployApp()
                    echo "Deploying the version ${params.VERSION} to env ${ENV}" 
                }
            }
        
        }
    }
}

