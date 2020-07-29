FROM openjdk:8-alpine AS builder
WORKDIR build/libs
ARG APPJAR=build/libs/*.jar
COPY ${APPJAR} app.jar
RUN jar -xf ./app.jar

FROM openjdk:8-alpine
VOLUME /tmp
ARG DEPENDENCY=build/libs
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.ejercicio.demo.DemoApplication"]