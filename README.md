# Pratical Project - CCT College!

 As a student I have been tasked to develop a Java program project for the Object Oriented with Design Pattern subject by my Lecture Amilcar Aponte.


# Assignment Introduction

The lecture provided access to a real database server that contains only one table (country), and I have been tasked to develop a Java program in charge of:

 - • Retrieve all records stored in the database table 
 - • Retrieve records by country name 
 - • Retrieve records by country code 
 - • Add new records into the database

## Specific Requirements

 - •You are required to implement the Data Access Object pattern, incombination with any other two creational patterns of your choice. 
 -  •You also have to create a simple CLI client program to test your implementation of the patterns. 
 - • You must create the class Country to model the entity on the database, as well as an ENUM to guarantee that the value of the continent matches the options on the database.
 - • You also are in charge of creating all the code corresponding to the interaction with the Database. 
 - • All object creation should be done following a design pattern of your choice.

## Object Orientation with Design Patterns used in the project

Singleton design pattern was used in the DatabaseConnection class to connect to the database passing and receive data in the form of objects.
The Abstract Design Pattern Factory was used in the CoutryDAOInterface class that will be implemented when calling the CountryDao class.

# Classes implemented
Continent.java
Country.java
CountryDAO.java
CountryDAOInterface.java
DatabaseConnection.java
Main.java


## Main Class
In the main class the user has the following options menu, where the user interface will be executed as required.

    System.out.println("\nCountry List Application\n");
    		System.out.println("Press 1 - List all countries");
    		System.out.println("Press 2 - Find country by code");
    		System.out.println("Press 3 - Find country by name");
    		System.out.println("Press 4 - Add a new country");
    		System.out.println("Press 5 - Exit");


## DatabaseConnection class
In this class I used singleton design pattern to connect with the database
private static DatabaseConnection instance;
...

     //Access point to the unique instance of the singleton
        public static DatabaseConnection getInstance() throws SQLException {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
            return instance;

## Country class
Class with all characteristics and methods required according to the database provided;
public class Country {
	

 - // Country's Code CHAR(3) 	private String code; 	
 - // Country's Name
 -    private String name; 	
 - // Continent where the Country is 	
 - private  String continent; 	
 - // Surface Area of the country 
 - private float surfaceArea; 	
 - // The Head of State's name 	
 - private String headOfState;

# Methods used to call, add and check countries by name or code. 

 1. getAllCountires() : return all countries in the database.     
 2. getCountriesByName(String name): It gets a list of countries by the same name.    
 3. getCountriesByCode(String code) : Get a list of ountries by code, returning only 1 result, as the code is unique.
 4. insertNewCountry(Country country): Add a country to the database.

@Anaiana
