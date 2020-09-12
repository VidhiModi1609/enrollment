Introduction

Implementation of Enrollment Service using SpringBoot,JPA and H2 database.

Relations
Enrollee :
It contains below fields:
  id,
  name VARCHAR(250),
  activation_status char(1), 
  birth_date DATE,
  phone_number VARCHAR(250)
  
Dependent :

It contains below fields:
  id,
  name VARCHAR(250),
  birth_date DATE,
  enrollee_id INT NOT NULL,
  

APIs

 /enrollment-api/enrollees : It provides list of enrollees and corresponding dependents
 /enrollment-api/enrollee":It is a post request that requests Enrollee details as paramaters and saves it in "Enrollee" table.
 /enrollment-api/enrollee/1:It will be used to delete enrollee details
 
 /enrollment-api/dependent":It is a post request that requests dependent details as paramaters and saves it in "dependent" table.
 /enrollment-api/dependent/1:It will be used to delete dependent details