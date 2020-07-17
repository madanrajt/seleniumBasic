pipeline {
  agent any
  tools {
    maven 'Maven_Home'
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
  }
}
