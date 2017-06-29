#!/bin/bash

gradle build -b Eureka/build.gradle 
gradle build -b Zuul/build.gradle 

gradle build -b R1/build.gradle
gradle build -b R2/build.gradle
gradle build -b RomaTre/build.gradle 




