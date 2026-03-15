pipeline {
agent any
stages {
stage('Build Spring Boot') {
steps {
bat './mvnw clean package -DskipTests'
}
}

stage('Docker Build') {
steps {
bat 'docker-compose build'
}
}

stage('Docker Deploy') {
steps {
bat 'docker-compose up -d'
}
}

stage('Integration Test') {
steps {
bat './mvnw verify'
}
}

}
}