#!/user/bin/env groovy

def call(String imageName) {
    echo "building the docker artifact for branch $BRANCH_NAME"
    sh "docker build -t $imageName ."

}