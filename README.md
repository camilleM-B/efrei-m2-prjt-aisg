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
* launch Tomcat
* Go to this url: ""


##Self-evaluation

* Create REST Train Filtering service B--------------------------------------------------------- 5/6

+: The service B is able to Filter train via SQL queries depending on multiples arguments passed (departures and arrivals stations, number of tickets, class of train) and display a list of corresponding trains id and their associated price
[amelioration possible = add something so that only train with available tickets are displayed? Not pratical if someone want to just check the arrival of a relative for exemple]

-: The filtering only be done with a predefined number and type of criteria
* Create SOAP Train Booking service A ------------------------------------------------------- X/4
* Interaction between two services ------------------------------------------------------------- X/4
* Test with Web service Client (instead of using Eclipse's Web service Explorer) - 1/2

-: We did not made a GUI for all possibles interactions

* Work with complex data type (class, table, etc.) ------------------------------------------ 1/2

+: We used different classes to organize the different url routing possibilities corresponding to the different filters available.

-: We only used arrayList as they were the simplest way to stock and transfer data between our functions
* Work with database (in text file, xml, in mysql, etc.) ------------------------------------- 2/2

+: We used a persistent mysql database to stock the trains. We use queries to directly filter results in the database and can update it.
* Postman --------------------------------------------------------------------------------------------- X/2
* OpenAPI --------------------------------------------------------------------------------------------- 1/3

+: The test done compile and send to the correct url

-: It does not fetch any results even through it do access the correct url, we suspect that the page do not send an acceptable format of data regarding what has been definied.
Since our first test did not work we did not do an OpenApi for the full scope of our project

TOTAL ------------------------------------------------------------------------------------------------------ X/25