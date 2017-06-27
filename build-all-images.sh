#!/bin/bash

source "docker.env"

DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker build --rm -t ${DOCKER_REGISTRY}/eureka-img-9006 ./Eureka
docker build --rm -t ${DOCKER_REGISTRY}/zuul-img-9006 ./Zuul

docker build --rm -t ${DOCKER_REGISTRY}/r1-img-9006 ./R1
docker build --rm -t ${DOCKER_REGISTRY}/r2-img-9006 ./R2
docker build --rm -t ${DOCKER_REGISTRY}/romatre-img-9006 ./RomaTre