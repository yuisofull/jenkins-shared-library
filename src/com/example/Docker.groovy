#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
	
	def script

	Docker(script) {
		this.script = script
	}

	def buildDockerImage(String imageName) {
		script.echo "building the docker image for $imageName"
		script.sh "docker build -t $imageName ."
		script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        		srcipt.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        		script.sh "docker push $imageName"
		}
	}
}
