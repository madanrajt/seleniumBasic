pipeline {
    agent any

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
        always {
          emailext (
            subject:'Jenkins Build Test for XUSDK', 
            mimeType: 'text/html', 
            to: 'madan231193@gmail.com','madan231193@gmail.com',
            recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'RequesterRecipientProvider']], 
            body: 'Testing Jenkins sending an email message after building a job.'
            )
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
