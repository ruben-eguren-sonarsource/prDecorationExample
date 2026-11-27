# prDecorationExample

A simple Java (Maven) example project.

## Requirements

- JDK 17+
- Maven 3.8+

## Build & test

```bash
mvn clean verify
```

## Run

```bash
mvn compile exec:java -Dexec.mainClass=com.example.prdecoration.App
```

Or after packaging:

```bash
mvn package
java -cp target/prDecorationExample-1.0.0-SNAPSHOT.jar com.example.prdecoration.App
```

## Notes

This section was added on branch feature/a.
