def groovyfile
pipeline {
    agent any
    parameters {
        // string(name: 'VERSION', defaultValue: '1.0.0', description: 'version to deploy')
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: 'choice a specific version')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'execute/skip test stage')
    }
    stages {
        stage('init') {
            steps {
                groovyfile = load 'script.groovy'
            }
        }
    }
    stages {
        stage('build') {
            steps {
                script {
                    groovyfile.buildApp()
                }
            }
        }
    
        stage('test') {
            when {
                expression {
                    params.executeTests == true //no need to use == true   //you can also use !params.executeTests
                }
            }
            steps {
                script {
                    groovyfile.testApp()
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    groovyfile.deployApp()
                }
            }
        
        }
    }
}
