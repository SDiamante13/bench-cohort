Feature: Greetings Service

  Scenario: Just a Greeting
    When a greeting message is requested
    Then the system will reply with "Hello my friend!"
  Scenario: Random Greeting
    When a User with the name Joe requests a greeting message
    Then the system will reply with one of the following messages:
      | Hello Joe!                     |
      | Hey Joe, nice to see you here! |
      | Joe welcome back!              |
      | Have a splendid day Joe.       |
