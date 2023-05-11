#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    //echo "building the docker image for $imageName"
    //sh "docker build -t $imageName ."
    return new Docker(this).buildDockerImage(imageName)
}
