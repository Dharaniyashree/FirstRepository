@ignore
@tag
Feature: Test home page
  I want to use this template for my feature file
  
  Background: Define url
  Given url 'https://conduit-api.bondaracademy.com/api/'
 

  @tag1
  Scenario: Get the tags
    Given 'tags'
    When method Get
    Then status 200
