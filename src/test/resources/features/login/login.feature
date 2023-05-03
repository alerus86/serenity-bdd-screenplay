Feature: Login to Luma ecommerce
  As a user
  I attempt to log in to the web page
  and check the behavior

  Scenario Outline: User accesses correctly
    Given that <user> accesses to Luma in the environment <env>
#  When
#  Then

    @qa
    Examples:
      | user                          | env    |
      | ravenautomation2012@gmail.com | QA_URL |