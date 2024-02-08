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
    }

           stage('Generate Allure report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }

        stage('Email') {
    steps {
        script {
            -Dhudson.tasks.MailSender.SEND_TO_UNKNOWN_USERS=true,
          subject: "pipeline result",
                body: "The Jenkins pipeline has completed. Please check the console output for details.",
                recipientProviders: [[$class: 'CulpritsRecipientProvider']],
                to: 'madan231193@gmail.com',
                attachmentsPattern: '**/allure-report/**'
        }
    }
}

}
  
}
