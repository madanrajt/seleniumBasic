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
  script {
    if (currentBuild.currentResult == 'SUCCESS') {
      step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: "madan231193@gmail.com", sendToIndividuals: true])
    }
  }
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
