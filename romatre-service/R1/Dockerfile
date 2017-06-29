FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/R1-0.0.1-SNAPSHOT.jar R1.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "R1.jar"]
