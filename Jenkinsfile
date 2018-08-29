pipeline {

agent any

    stages {
        stage ('Initialise') {
            steps {
                script {
                    sh 'git rev-parse HEAD > commit'
                    env.GIT_COMMIT = readFile('commit').trim()

                    sh 'git rev-parse --short HEAD > short_commit'
                    env.GIT_COMMIT_SHORT = readFile('short_commit').trim().toLowerCase()

                    sh '''
                        echo ${GIT_BRANCH}|sed 's#feature/##' > branch_name
                      '''
                    env.BRANCH_NAME_CLEAN = readFile('branch_name').trim().toLowerCase()
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                       '''

                }
            }
        }
        stage ('Run unit test'){
            steps {
                sh './mvnw test'
            }
        }
        stage ('Build JAR and upload to nexus') {
            steps {
                sh './mvnw -Dmaven.test.failure.ignore=false -Dsettings.security=settings-security.xml -s settings.xml clean install deploy'
            }
        }


    }
}