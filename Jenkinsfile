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
agent {lable 'docker-agent'}
steps {
sh 'docker-compose build'
}
}

stage('Docker Deploy') {
agent {lable 'docker-agent'}
steps {
sh 'docker-compose -d up'
}
}

stage('Integration Test') {
agent {lable 'jdk-maven-agent'}
steps {
sh './mvnw verify'
}
}

}
}