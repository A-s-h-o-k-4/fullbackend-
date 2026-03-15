pipeline {
agent none
stages {
stage('Build Spring Boot') {
agent {label 'jdk-maven-agent'}
steps {
sh './mvnw clean package'
}
}

stage('Docker Build') {
agent {label 'docker-agent'}
steps {
sh 'docker-compose build'
}
}

stage('Docker Deploy') {
agent {label 'docker-agent'}
steps {
sh 'docker-compose -d up'
}
}

stage('Integration Test') {
agent {label 'jdk-maven-agent'}
steps {
sh './mvnw verify'
}
}

}
}