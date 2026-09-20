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
}
