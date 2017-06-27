#!/bin/bash

gradle clean -b Eureka-server/build.gradle 
gradle clean -b Zuul-server/build.gradle

gradle clean -b R1/build.gradle
gradle clean -b R2/build.gradle
gradle clean -b RomaTre/build.gradle 




