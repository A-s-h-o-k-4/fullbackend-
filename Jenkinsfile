pipeline {
agent any
stages {
stage('Build Spring Boot') {
steps {
bat './mvnw clean package'
}
}

stage('Docker Build') {
steps {
bat 'docker-compose build'
}
}

stage('Docker Deploy') {
steps {
bat 'docker-compose -d up'
}
}

stage('Integration Test') {
steps {
bat './mvnw verify'
}
}

}
}