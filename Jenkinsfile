pipeline {
    agent any
    environment {
            EMAIL_INFORM = 'madan231193@gmail.com;madan231193@gmail.com'
        }
    tools {
        maven "MAVEN"
        jdk "JDK"
    }
    stages {
        stage ('Initialize MAVEN') {
            steps {
                    echo "PATH = ${M2_HOME}/bin:${PATH}"
                    echo "M2_HOME = /opt/maven"
            
            }

            
        }

        stage ('Run test') {
            steps {
                sh 'mvn -D clean test'
            }
  post {

            success {  
                emailext body: 'Check console output at $BUILD_URL to view the results.', 
                        to: "${EMAIL_INFORM}", 
                        subject: 'Jenkins - Released $PROJECT_NAME - #$BUILD_NUMBER'
            }
        }
        }

           stage('Generate Allure report') {
            
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        results: [[path: 'allure-results']]
                    ])
                }
            }
           }


}
  
}
