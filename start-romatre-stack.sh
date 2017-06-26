#!/bin/bash

echo 'Starting RomaTre application as a stack' 

docker stack deploy --compose-file docker-stack-romatre-9006.yml romatre-9006
