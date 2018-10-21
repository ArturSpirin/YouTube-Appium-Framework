## How to create mobile automation framework

This repository  is a product of a YouTube series: [Appium Tutorial - How to Create Mobile Automation Framework](https://www.youtube.com/watch?v=fCrpi_or7zU&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW).

This series takes you from creating new project to full fledged automation framework. 
Everything is done step by step and accessible format. Conceptually the design of this framework can be applied to any 
other automation category, not just mobile.


You are free to use this work and modify it as long as you credit the original creator by:

1. Providing link back to [My GitHub](https://github.com/ArturSpirin)
2. Providing link to the [YouTube channel](https://www.youtube.com/c/ArturSpirin)

##
## Table of Content
+ [Getting Started](https://www.youtube.com/watch?v=fCrpi_or7zU&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Creating initial project structure with all the packages and classes.
+ [UI Selectors](https://www.youtube.com/watch?v=rAjErGEVMzs&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Wrapper for UiSelector to simplify integration with Appium.
+ [UI Object - Part 1](https://www.youtube.com/watch?v=exZS6Qo_2R0&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Wrapper for UI Objects to simplify actions like tap, scroll, type, pinch and more.
+ [UI Object - Part 2](https://www.youtube.com/watch?v=0ZsQ0ME812M&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Finishing up the wrapper by adding more functions like wait for element to appear.
+ [ADB Integration - Part 1](https://www.youtube.com/watch?v=fzou-tKQJTU&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Adding Server Manager and starting ADB integration
+ [ADB Integration - Part 2](https://www.youtube.com/watch?v=f8gB9Rfdyd4&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Continue adding more functions to ADB classes to better understand the stats of the mobile device
+ [ADB Integration - Part 3](https://www.youtube.com/watch?v=banaRv80IHA&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Finishing up ADB integration by adding extended support for logcat
+ [Integrating Log4J](https://www.youtube.com/watch?v=lOpuz7JTN7Y&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - For better debugging capabilities, adding logging functionality
+ [Testing Code thus far](https://www.youtube.com/watch?v=QtZ96JDycEE&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Going to test everything we wrote so far and fix any outstanding issues
+ [Driver Manager](https://www.youtube.com/watch?v=OYVxk-9o9Pg&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Support class for managing the Android Driver
+ [Application Page Objects - Part 1](https://www.youtube.com/watch?v=qBh1ddVluMY&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Start to build out the application's page object matrix for Speedtest.net's mobile app. 
  Will be utilizing the wrappers that we built in the very early stages of this framework.
+ [Application Page Objects - Part 2](https://www.youtube.com/watch?v=5NQ1DV3L5QA&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Continue to build page objects and map activities of the Speedtest mobile app. 
+ [Application Page Objects - Part 3](https://www.youtube.com/watch?v=2sGpbj_-rtc&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Finishing up the matrix and validating that we have proper return types from all of the activities.
+ [Implementing Test Info class](https://www.youtube.com/watch?v=0tR4DCuHJgA&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Metadata class for keeping baisc information about the test such as: name, id, test suite, etc
+ [Test Manager](https://www.youtube.com/watch?v=0FphMZnL_PM&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  -  It will manage all of our test preconditions and what to do when test passes/fails. Will utilize JUnit for this.
+ [Create test cases](https://www.youtube.com/watch?v=9Bk4hOqHjc8&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Will use Page Objects that we have created in order to write some basic UI tests. 
  We will navigate through a number of screens and verify that specific elements exist. 
  We will also do one functional test and verify all the elements.
+ [Operationalizing Appium Server](https://www.youtube.com/watch?v=4IX49gyQQ1Y&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Start Appium server programmatically thus having no need to do it manually in the terminal.
+ [Packaging the framework](https://www.youtube.com/watch?v=hUJRu4jfPHY&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Will build the jar
+ [Running framework](https://www.youtube.com/watch?v=C53Jc5YRlIU&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Will run framework from the jar
+ [Parallel Testing](https://www.youtube.com/watch?v=U0ufO6feLjU&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - How to run framework in order to run tests in parallel on different devices
+ [XML Reports](https://www.youtube.com/watch?v=eq8Wsjz7dT0&list=PLK7KNOA7vbPOh_2sx4aKnU0y6DDUFtQaW)
  - Creating XML reports in Jenkins Format
  
More tutorials can be found on my [YouTube channel](https://www.youtube.com/c/ArturSpirin)