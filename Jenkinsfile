pipeline {
    agent any

     options {
        buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '2'))
    }
    environment {
        U2B_TOKEN     = credentials('jenkins-aws-secret-key-id')
        U2B_USER = credentials('jenkins-aws-secret-access-key')
        U2B_PASSWORD = "matchengine-${BUILD_ID}.jar"

    }

    stages{

        stage('Checkout Project') {
            steps {
                echo "-=- Checout project -=-"
                git branch: 'master', url: 'https://github.com/pharaphara/uptoboxClientApi.git'
            }

        stage('Update Lambda ENV ') {
            steps {
                sh'cat ../output.txt | tr -d \' "\'>environment.txt'
                withEnv(readFile('environment.txt').split('\n') as List) {
                    sh "U2B_TOKEN=${U2B_TOKEN}"
                    sh "U2B_USER=${walletapp_URL}"
                    sh "echo ${prodDB_URL}"


                    sh 'aws lambda update-function-configuration --function-name user-create-user --environment \'{"Variables":{"prodDB_URL":"\'${prodDB_URL%:*}\'"}}\''
                     sh 'aws lambda update-function-configuration --function-name update-user --environment \'{"Variables":{"prodDB_URL":"\'${prodDB_URL%:*}\'"}}\''
                     sh 'aws lambda update-function-configuration --function-name user-check-email --environment \'{"Variables":{"prodDB_URL":"\'${prodDB_URL%:*}\'"}}\''
                     sh 'aws lambda update-function-configuration --function-name current-user --environment \'{"Variables":{"prodDB_URL":"\'${prodDB_URL%:*}\'"}}\''
                    sh 'aws lambda update-function-configuration --function-name authenticate-user --environment \'{"Variables":{"prodDB_URL":"\'${prodDB_URL%:*}\'"}}\''

                }
            }
        }



    }
}