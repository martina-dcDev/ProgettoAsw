#!/bin/bash

source "docker.env"

DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker push ${DOCKER_REGISTRY}/eureka-img-9006
docker push ${DOCKER_REGISTRY}/zuul-img-9006

docker push ${DOCKER_REGISTRY}/r1-img-9006
docker push ${DOCKER_REGISTRY}/r2-img-9006
docker push ${DOCKER_REGISTRY}/romatre-img-9006
