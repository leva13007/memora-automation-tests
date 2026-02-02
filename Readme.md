# Memora UI Test (Maven) Project

Check existing maven on your machine before creating a new project.
```bash
mvn --version 
```

Execute the following command in your terminal to create an empty Memora UI test(Maven) project:
```bash
mvn archetype:generate -DgroupId=dev.memora -DartifactId=memora-ui-test -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```

To run the specific test file, use the following command:
```bash
mvn -Dtest=YourTestFileName test
```
Replace `YourTestFileName` with the actual name of the test file you want to execute.

To run a specific test method within a test file, use the following command:
```bash
mvn -Dtest=YourTestFileName#yourTestMethodName test
```
Replace `YourTestFileName` with the name of the test file and `yourTestMethodName` with the name of the test method you want to execute.
