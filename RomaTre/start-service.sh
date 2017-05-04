#!/bin/bash

# Script per avviare il servizio RomaTre

echo Running RomaTre

java -Xms64m -Xmx128m -jar ./build/libs/RomaTre-0.0.1.jar
