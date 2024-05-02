# Discover Card Application Automation

This repository contains an automation framework designed to interact with the Discover card application process. Using Selenium WebDriver, this project focuses on dynamically handling URL parameters during the pre-fill stage, ensuring a robust interaction with the Discover website.

## Project Structure

The project is organized into several key directories:

- `src/main/java/com/corserv/pages`: Contains page object models for each page interacted with during the tests.
- `src/main/java/com/corserv/util`: Utility classes, such as `UrlUtils` for dynamic URL manipulations.
- `src/main/java/com/corserv/config`: Configuration management classes for dynamic properties loading.
- `src/test/java`: Test classes for executing automated test scenarios.
- `src/main/resources`: Configuration files and other resources needed for tests.


## Installing Dependencies

Install all necessary dependencies by running the following command in the project root directory:

`mvn clean install`


## Running Tests

`mvn test`


