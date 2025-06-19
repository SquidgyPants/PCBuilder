## Dockerfile
#FROM node:18
#WORKDIR /app
#COPY package*.json ./
#RUN npm install
#COPY . .
#CMD ["npm", "start"]

FROM amazoncorretto:23

WORKDIR /app

COPY target/back-end-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]