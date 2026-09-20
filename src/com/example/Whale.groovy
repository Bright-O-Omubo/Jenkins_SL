package com.example

class Whale implements Serializable  {

    def script

    Whale (script) {
        this.script= script
    }
    def imageBuild(String imageName) {
        script.echo "building the docker artifact for branch ${script.BRANCH_NAME}"
        script.sh "docker build -t script.$imageName ."

    }
    def testBuild(String imageName ) {
        script.echo "testing health for image $imageName"
    }
    def deployBuild(String imageName) {
        script.withCredntials ([
                script.usernamePassword (
                        crednetialsId: 'dockerhub-creds',
                        usernameVariable: 'USER',
                        passwordVariable: 'PASS'
                )
        ]) {
            {
                script.sh "echo ${script.PASS} | docker login -u ${script.USER} --password-stdin"
                script.sh "docker push artifact $imageName"
            }
        }
    }
}
