###############################################
# Dockerfile per l'applicazione RomaTre server 
###############################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/romatre-0.0.1.jar romatre.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "romatre.jar"]

