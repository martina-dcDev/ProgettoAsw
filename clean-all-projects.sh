#!/bin/bash

gradle clean -b Eureka/build.gradle 
gradle clean -b Zuul/build.gradle

gradle clean -b R1/build.gradle
gradle clean -b R2/build.gradle
gradle clean -b RomaTre/build.gradle 




