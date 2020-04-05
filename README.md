# Pratical Project - CCT College!

 As a student I have been tasked to develop a Java program project for the Object Oriented with Design Pattern subject by my Lecture Amilcar Aponte.


# Assignment Introduction

The lecture provided access to a real database server that contains only one table (country), and I have been tasked to develop a Java program in charge of:
• Retrieve all records stored in the database table
• Retrieve records by country name
• Retrieve records by country code
• Add new records into the database

## Specific Requirements
•You are required to implement the Data Access Object pattern, in combination with any other two creational patterns of your choice.
• You also have to create a simple CLI client program to test your implementation of the patterns.
• You must create the class Country to model the entity on the database, as well as an ENUM
to guarantee that the value of the continent matches the options on the database.
• You also are in charge of creating all the code corresponding to the interaction with the
Database.
• All object creation should be done following a design pattern of your choice.


## Object Orientation with Design Patterns used in the project

Singleton design pattern was used in the DatabaseConnection class to connect to the database passing and receive data in the form of objects.
The Abstract Design Pattern Factory was used in the CoutryDAOInterface class that will be implemented when calling the CountryDao class.


## Main Class
In the main class the user has the following options menu, where the user interface will be executed as required.

System.out.println("\nCountry List Application\n");
		System.out.println("Press 1 - List all countries");
		System.out.println("Press 2 - Find country by code");
		System.out.println("Press 3 - Find country by name");
		System.out.println("Press 4 - Add a new country");
		System.out.println("Press 5 - Exit");


## CountryDAO class
