pipeline {
agent any
stages {
stage('Build Spring Boot') {
steps {
sh './mvnw clean package'
}
}

stage('Docker Build') {
steps {
sh 'docker-compose build'
}
}

stage('Docker Deploy') {
steps {
sh 'docker-compose -d up'
}
}

stage('Integration Test') {
steps {
sh './mvnw verify'
}
}

}
}