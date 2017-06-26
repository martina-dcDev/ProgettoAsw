FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/R2-0.0.1-SNAPSHOT.jar R2.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "R2.jar"]

