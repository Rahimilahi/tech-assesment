Feature:
  Scenario:
    Given i perform a "GET" method with a status of "available"
    When i sort by by name "doggie" and status "available"
    Then i should see 188 pets are returned with name "doggie" and status "available"



