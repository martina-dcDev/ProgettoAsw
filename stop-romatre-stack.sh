#!/bin/bash

echo 'Removing RomaTre application as a stack' 

source "docker.env"

docker stack rm romatre-9006
