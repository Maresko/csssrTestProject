@testCase
Feature: test feature

  Scenario: checkin checkbox
    Given open Chrome browser
    Given open page "http://blog.csssr.ru/qa-engineer/"
    And click element "НАХОДИТЬ НЕСОВЕРШЕНСТВА" on "job page" page
    And click element "Чувство прекрасного" on "job page" page
    And click element "Чувство прекрасного" on "job page" page
    Then check that checkbox is on