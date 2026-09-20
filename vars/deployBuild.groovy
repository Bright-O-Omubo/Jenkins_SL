#!/user/bin/env groovy

import com.example.Whale

def call (String imageName) {
    return new Whale(this).deployBuild(imageName)
}
