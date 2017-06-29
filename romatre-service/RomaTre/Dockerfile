FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/romatre-0.0.1-SNAPSHOT.jar romatre.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "romatre.jar"]

