Feature: Belly after eating cukes
  In order to "Know how my belly will react" (capability)
  As a belly owner
  I want to know what will happen if I eat cukes

  @quick
  Scenario: eat just a few cukes and no wait
    Given I have 1 cuke in my belly
    When I don't wait
    Then My belly should be "silent"

  @quick
  Scenario: many cukes and wait one hour
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then My belly should "growl"

  @slow
  Scenario Outline: belly reactions after eating cukes
    Given I have <count> cukes in my belly
    When  I wait <time> hour
    Then My belly should "<reaction>"
    Examples: # time is hours
      | count | time | reaction |
      | 3     | 1    | silent   |
      | 20    | 1    | silent   |
      | 21    | 1    | growl    |
      | 21    | 2    | growl    |
      | 21    | 0    | silent   |
      | 50    | 0    | silent   |
      | 50    | 5    | growl    |

