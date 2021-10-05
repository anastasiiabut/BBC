Feature: Smoke
  As a student
  I aim at demonstrating my skills of writing automation tests
  By checking that BBC site works correctly

  Scenario Outline: Check that a title of headline article is the expected title
    Given User opens '<homepage>' page
    And User clicks on 'News' button
    Then User checks that the name of headline article is '<title>'

    Examples:
      |homepage             | title                                             |
      |https://www.bbc.com/ | Facebook weakens democracy, says ex-employee|

  Scenario Outline: Check that a title of the second article is the expected title
    Given User opens '<homepage>' page
    And User clicks on 'News' button
    Then User checks that the name of the second article is '<title>'

    Examples:
      |homepage             | title                                  |
      |https://www.bbc.com/ | Six hours without WhatsApp|

  Scenario Outline: Check that a title of the first article is the expected title
    Given User opens '<homepage>' page
    And User clicks on 'News' button
    And User stores the text of category link of the headline article
    When User inputs this text in the search filed
    And User clicks on search field button
    Then User checks that the name of the first article is '<title>'

    Examples:
      |homepage             | title                    |
      |https://www.bbc.com/ | Ros Atkins On...: The North America Heatwaves |

  Scenario Outline: Check incorrect inputs to send BBC a story
    Given User opens '<homepage>' page
    And User clicks on 'News' button
    And User clicks on 'Coronavirus' tab
    And User clicks on 'Your Coronavirus Stories' tab
    When User clicks on 'How to share with BBC NEWS'
    And User shares his or her '<story>'
    And User inputs his or her '<name>'
    And User clicks on 'Submit' button
    And User checks the acceptance of the Terms of Service error message visibility
    And User refreshes page
    And User shares his or her '<story>'
    And User accepts the Terms of Service
    And User clicks on 'Submit' button
    And User checks the name error message visibility
    And User refreshes page
    And User inputs his or her '<name>'
    And User accepts the Terms of Service
    And User clicks on 'Submit' button
    Then User checks the story error message visibility

    Examples:
      |homepage             | story        | name      |
      |https://www.bbc.com/ | Hello world! | John Galt |

  Scenario Outline: Check teams and their results
    Given User opens '<homepage>' page
    And User clicks on 'Sport' button
    And User clicks on 'Football' tab
    And User clicks on 'Scores and Fixtures' tab
    And User inputs a '<championship>' in the search field
    And User selects results for a '<month>'
    And User checks that '<one team>' played with '<another team>' and have '<one>' and '<another>' results
    And User clicks on the first team
    And User checks that the score is '<one>' and '<another>'
    And User checks that teams are '<one team>' and '<another team>'
    Examples:
      | homepage             | month | championship          | one team               | another team     | one | another |
      | https://www.bbc.com/ | SEP   | Scottish Championship | Raith Rovers           | Partick Thistle  | 3   | 2       |
      | https://www.bbc.com/ | MAR   | Premier League        | Brighton & Hove Albion | Newcastle United | 3   | 0       |
      | https://www.bbc.com/ | MAY   | Championship          | Brentford              | AFC Bournemouth  | 3   | 1       |
      | https://www.bbc.com/ | APR   | Champions League      | Real Madrid            | Chelsea          | 1   | 1       |
      | https://www.bbc.com/ | FEB   | Europa League         | Tottenham Hotspur      | RZ Pellets WAC   | 4   | 0       |


