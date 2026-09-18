#!/user/bin/env groovy

def call(String imageName) {
    echo "deploying artifact $imageName to dockerhub for $BRANCH_NAME"
    withCredentials([
            usernamePassword (
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: USER,
                    passwordVariable: PWD
            )
    ]) {
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
}