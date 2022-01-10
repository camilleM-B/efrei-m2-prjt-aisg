# efrei-m2-prjt-aisg
projet of architecture &amp; IS gouvernance - Timothé CHAUVET &amp; Camille MATHIEU

# Architecture and IS Governance project

Client <-> SOAP Train booking <-> REST Train filtering

## To-do list

### Train booking *(SOAP)*

* User authentification
* Reserve a seat by
 * Providing train ID
 * Travel class (First, Business, Standard)
 * Ticket type (Flexible, Not flexible)
* 


## Technos

* Eclipse WTP or Terminal mode
* Restlet or Jersey framework (create services)


##How to install and run your services

* this project use jdk 14
* install the jar found in the jar files
* launch the RestDistributor class


##Self-evaluation

* Create REST Train Filtering service B--------------------------------------------------------- 5/6

+: The service B is able to Filter train via SQL queries depending on multiples arguments passed (departures and arrivals stations, number of tickets, class of train) and display a list of corresponding trains id and their associated price
[amelioration possible = add something so that only train with available tickets are displayed? Not pratical if someone want to just check the arrival of a relative for exemple]

-: The filtering only be done with a predefined number and type of criteria
* Create SOAP Train Booking service A ------------------------------------------------------- 4/4
* Interaction between two services ------------------------------------------------------------- 4/4
* Test with Web service Client (instead of using Eclipse's Web service Explorer) - 2/2
* Work with complex data type (class, table, etc.) ------------------------------------------ 0/2

-: We only used arrayList as they were the simplest way to stock and transfer data between our functions
* Work with database (in text file, xml, in mysql, etc.) ------------------------------------- 2/2

We used a persistent mysql database to stock the trains
* Postman --------------------------------------------------------------------------------------------- 2/2
* OpenAPI --------------------------------------------------------------------------------------------- 3/3

TOTAL ------------------------------------------------------------------------------------------------------ X/25