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
        stage('Code coverage') {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage('Mutation test') {
            steps {
                sh "./gradlew pitest"
                publishHTML (target: [
                    reportDir: 'build/reports/pitest',
                    reportFiles: 'index.html',
                    reportName: 'Pitest Report'
                ])
            }
        }
        stage('Static code analysis') {
            steps {
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: 'Checkstyle Report'
                ])
            }
        }
    }
}