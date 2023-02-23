FROM eclipse-temurin:17-alpine

WORKDIR /app
COPY . .
ENV SPRING_PROFILES_ACTIVE=prod
RUN ./gradlew build --no-daemon --exclude-task test
CMD ["java", "-jar", "./build/libs/outdoor-shopping-product-0.1.jar"]
