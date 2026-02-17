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

To run all tests that marked with a specific tag, use the following command:
```bash
mvn -Dgroups=yourTagName test
```
Replace `yourTagName` with the name of the tag you want to execute.

The tag name comes fromt the `@Tag` annotation in your test code. For example, if you have a test method annotated with `@Tag("smoke")`, you can run all tests with the "smoke" tag using the command above.

```java
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
 @Tag("smoke")
 @Test
  public void testMethod() {
      // test code here
  }
```

```bash
mvn -Dgroups=smoke test
```

In this project there are these specific tags:
- `@Tag("smoke")`: This tag is used to mark tests that are part of the smoke testing suite. Smoke tests are a subset of tests that cover the most critical functionalities of the application. They are typically run to quickly verify that the basic features of the application are working as expected after a new build or deployment.
- `@Tag("regression")`: This tag is used to mark tests that are part of the regression testing suite. Regression tests are designed to ensure that recent code changes have not adversely affected existing functionality. They are typically run after new features are added or bugs are fixed to verify that the application still behaves as expected.