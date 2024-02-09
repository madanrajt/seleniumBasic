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
        failure {
        mail to: 'madan231193@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
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
           stage('Second Mail') {
            steps {
                emailext   
                    to:     'madan231193@gmail.com',
                    from:       'cicd1993@gmail.com',
                    subject:    "Secont Mail", 
                    body:       "Here is the content of the second Mail"
            }
        } 


}
  
}
