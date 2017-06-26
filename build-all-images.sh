#!/bin/bash

source "docker.env"


DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker build --rm -t ${DOCKER_REGISTRY}/eureka-server-img-9006 ./Eureka-server 
docker build --rm -t ${DOCKER_REGISTRY}/romatre-img-9006 ./RomaTre
docker build --rm -t ${DOCKER_REGISTRY}/R1-img-9006 ./R1
docker build --rm -t ${DOCKER_REGISTRY}/R2-img-9006 ./R2
docker build --rm -t ${DOCKER_REGISTRY}/zuul-img-9006 ./Zuul-server