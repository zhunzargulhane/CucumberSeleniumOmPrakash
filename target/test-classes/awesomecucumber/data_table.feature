#Feature: DataTable learning
##single row with no header
#  Scenario: Single row with no header
#    Given I'm entering credentials
#      | user | user123 |
#
#  Scenario: Multiple rows with no header
#    Given I'm entering credentials multiple rows
#      | user | user123 |
#      | john | john123 |
#
#  Scenario: Single row with header
#    Given I'm entering credentials single rows with header
#      | username | password |
#      | user     | user123  |
#
#  Scenario: Multiple rows with header using customDataTableType
#    Given I'm entering credentials multiple rows using DataTableType
#      | username | password |
#      | user     | user123  |
#      | john     | john123  |
#
#
#  Scenario: single rows with header using customDataTableType
#    Given I'm entering credentials single row using DataTableType
#      | username | password |
#      | user     | user123  |
#    #When user use the credentials
#
#  Scenario: SINGLE COLUMN WITH NO HEADER
#    Given I'm entering credentials single COLUMN with no header
#      | uSER123 |
#      | demo    |
#
#
#  Scenario: SINGLE COLUMN WITH HEADER
#    Given I'm entering credentials single COLUMN with header
#      | username | uSER123 |
#      | password | demo    |
#
#  Scenario: SINGLE COLUMN WITH NO HEADER DATATABLE TYPE
#    Given I'm entering credentials single column no header datatable type
#      | uSER123 |
#      | demo    |
#
#  Scenario: SINGLE COLUMN WITH HEADER DATATABLE TYPE
#    Given I'm entering credentials single column with header datatable type
#      | username | uSER123 |
#      | password | demo    |
#
#
#
