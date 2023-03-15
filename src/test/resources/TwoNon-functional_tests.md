Feature: API Performance Testing

Scenario: Measure API Response Time under Different Loads
Given the API is available
When I send "<num_requests>" requests with "<num_concurrent_users>" concurrent users
Then the API response time should be less than "<expected_response_time>" ms

Scenario: Measure API Throughput under Different Loads
Given the API is available
When I send "<num_requests>" requests with "<num_concurrent_users>" concurrent users
Then the API throughput should be greater than "<expected_throughput>" requests/second




Feature: API Stress Testing

Scenario Outline: Measure API Response Time under Stress
Given the API is available
When I send "<num_requests>" requests with "<num_concurrent_users>" concurrent users for "<duration>" seconds
Then the API response time should be less than "<expected_response_time>" ms

    Examples:
      | num_requests | num_concurrent_users | duration | expected_response_time |
      | 1000         | 100                  | 30       | 1000                    |
      | 5000         | 500                  | 60       | 2000                    |
      | 10000        | 1000                 | 120      | 3000                    |

Scenario Outline: Measure API Throughput under Stress
Given the API is available
When I send "<num_requests>" requests with "<num_concurrent_users>" concurrent users for "<duration>" seconds
Then the API throughput should be greater than "<expected_throughput>" requests/second

    Examples:
      | num_requests | num_concurrent_users | duration | expected_throughput |
      | 1000         | 100                  | 30       | 20                  |
      | 5000         | 500                  | 60       | 50                  |
      | 10000        | 1000                 | 120      | 80                  |