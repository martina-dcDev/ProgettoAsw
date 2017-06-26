#!/bin/bash

source "docker.env"

DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker push ${DOCKER_REGISTRY}/eureka-server-img-9006
docker push ${DOCKER_REGISTRY}/romatre-img-9006
docker push ${DOCKER_REGISTRY}/R1-img-9006
docker push ${DOCKER_REGISTRY}/R2-img-9006
docker push ${DOCKER_REGISTRY}/zuul-img-9006
