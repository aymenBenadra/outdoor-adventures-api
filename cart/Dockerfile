FROM eclipse-temurin:17-alpine

WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon --exclude-task test
CMD ["./gradlew", "bootRun"]
