#!/bin/bash

docker network create eureka-net

docker run -d --network=eureka-net --name=eureka eureka-img-9006

docker run -d --network=eureka-net --name=r1 r1-img-9006
docker run -d --network=eureka-net --name=r2 r2-img-9006
docker run -d --network=eureka-net --name=romatre romatre-img-9006

docker run -d --network=eureka-net -p 8080:8080 --name=zuul zuul-img-9006