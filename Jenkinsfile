pipeline {
    agent any


    environment {
        M2_HOME = "/usr/share/maven"
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk-amd64"
        PATH = "${M2_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"

        SONARQUBE_URL = "http://localhost:9000/" // SonarQube server URL
        SONARQUBE_CREDENTIALS = 'SonarQube' // SonarQube credentials ID from Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'hassen',
                credentialsId: 'b0237264-56c1-4ef7-9387-5fadecede16f',
                url: "https://github.com/Devops-5BI/Spring-data-Devops.git"
            }
        }

        stage('Deploy to Nexus') {
                            steps {
                                    script{ sh 'mvn deploy'}
                                 }
        }


    }
}