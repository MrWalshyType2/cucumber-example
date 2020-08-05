#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

# This file is written in human-readable language (Gherkin)

@tag
Feature: Google search
  In order to search for items,
  As a user,
  I want to be able to search with Google

  #@tag1
  #Scenario: Google search Pokemon
    #Given I want to search in Google
    #When I search for "Pokemon"
    #Then I should see a link to "The Official Pokemon Website"

  @tag1
  Scenario Outline: Google search -> item
    Given I want to search in Google
    When I search for "<term>"
    Then I should see a link to "<result>"
		# Tags pull from Examples below and sends as a param
		# Test number = number of rows of data (3 rows of data = 3 tests)
    Examples: 
      | term  	| result 	 										 									| status  |
      | pokemon | https://www.pokemon.com/uk/  									| success |
      | oranges | https://en.wikipedia.org/wiki/Orange_(fruit)  | success |
      | bbc		  | https://www.bbc.co.uk/news									  | success |
