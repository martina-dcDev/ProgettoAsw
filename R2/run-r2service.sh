#!/bin/bash

# Script per avviare il servizio R2

echo Running R2

java -Xms64m -Xmx128m -jar build/libs/R2-0.0.1-SNAPSHOT.jar
