package com.example

class Whale implements Serializable  {

    def script

    Whale (script) {
        this.script= script
    }
    def imageBuild(String imageName) {
        script.echo "building the docker artifact for branch BRANCH_NAME"
        script.sh "docker build -t $imageName ."

    }
    def testBuild(String imageName ) {
        script.echo "testing health for image $imageName"
    }
    def deployBuild(String imageName) {
        script.withCredentials([
                script.usernamePassword (
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'USER',
                        passwordVariable: 'PASS'
                )
        ]) {

            script.sh "echo ${script.PASS} | docker login -u ${script.USER} --password-stdin"
            script.sh "docker push $imageName"

        }
    }
}
