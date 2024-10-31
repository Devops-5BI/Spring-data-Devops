pipeline {
    agent any


    environment {
        M2_HOME = "/usr/share/maven"
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk-amd64"
        PATH = "${M2_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
        SONARQUBE_URL = "http://localhost:9000/" // SonarQube server URL
        SONARQUBE_CREDENTIALS = 'SonarQube' // SonarQube credentials ID from Jenkins
        IMAGE_NAME = "hassen10/hassen5bi37"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'hassen',
                credentialsId: 'b0237264-56c1-4ef7-9387-5fadecede16f',
                url: "https://github.com/Devops-5BI/Spring-data-Devops.git"
            }
        }

         stage('Build') {
                    steps {
                        script {
                            sh 'mvn compile'
                        }
                    }
         }


         stage('SonarQube Analysis') {
                                     steps {

                                             withSonarQubeEnv('SonarQube') {
                                                 sh 'mvn sonar:sonar'
                                             }

                                     }
                 }

     /*   stage('Deploy to Nexus') {
                            steps {
                                     script{ sh 'mvn deploy'}
                                 }
        }*/


        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh """
                            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                            docker push ${IMAGE_NAME}:${BUILD_NUMBER}
                        """
                    }
                }
            }
        }




    }
}