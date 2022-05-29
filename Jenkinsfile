pipeline {
    agent {
        // label 'master-node'
        label 'docker-ssh-agent'
        // label 'docker-agent'
    }
    stages {
//         stage('Checkout') {
//             steps {
//                 git url: 'https://github.com/VitaliyDragun1990/test-calculator.git', branch: 'main'
//             }
//         }
        stage('Compile') {
            steps {
                sh "chmod +x ./gradlew" // in order to run ./gradlew
                sh "./gradlew compileJava"
            }
        }
        stage('Unit test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}