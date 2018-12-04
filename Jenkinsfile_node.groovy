// node scripted pipeline (单流水线风格）
// https://jenkins.io/doc/book/pipeline/jenkinsfile/
// https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Jenkins#app-switcher
// https://jenkins.io/doc/tutorials/create-a-pipeline-in-blue-ocean/
// https://jenkins.io/blog/2017/04/18/continuousdelivery-devops-sonarqube/
node {

    // jenkins workspace
    def PROJECT_PATH="/root/.jenkins/workspace/springcloudFeign"


    // config git
    stage('获取代码') {
        git credentialsId: 'e60e6c1f-244d-45c9-95b4-b7ddffa55384', url: 'http://172.20.4.39/bitauto/springcloudfeign.git'
    }

    stage('代码构建+代码检查') {
        withSonarQubeEnv('My SonarQube Server') {
            sh 'mvn clean package -DskipTests sonar:sonar'
        } // SonarQube taskId is automatically attached to the pipeline context
    }

    stage('构建镜像') {
        sh PROJECT_PATH +'/build-image.sh'
    }

    stage('更新镜像') {
        sh PROJECT_PATH +'/update-image.sh'
    }

    // No need to occupy a node
    stage("Quality Gate") {
        timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
            def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }

}


