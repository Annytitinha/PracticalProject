import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLCountryDAO implements CountryDAO {

	@Override
	public ArrayList<Country> getCountrieis() {
		
		// List to return
		ArrayList<Country> list = new ArrayList<Country>();
		
		// Connecting to DB
		DataSource db = new DataSource();
		
		// Querying the Database
		ResultSet rs = db.select("select * from country;");
		
		try {
		
			// Looping over results
			while(rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continentString = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				// Converting the string to a ENUM
				Continent continent = null;
				if (continentString.equals("Asia")) {
					continent = Continent.ASIA;
				}
				else if (continentString.equals("Europe")) {
					continent = Continent.EUROPE;
				}
				else if (continentString.equals("North America")) {
					continent = Continent.NORTH_AMERICA;
				}
				else if (continentString.equals("Africa")) {
					continent = Continent.AFRICA;
				}
				else if (continentString.equals("Antarctica")) {
					continent = Continent.ANTARCTICA;
				}
				else if (continentString.equals("Oceania")) {
					continent = Continent.OCEANIA;
				}
				else if (continentString.equals("South America")) {
					continent = Continent.SOUTH_AMERICA;
				}
			
				// Creating the Country object using the builder
				Country c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build();
				
				// Adding object to the list
				list.add(c);

			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// returning the list
		return list;
	}

	@Override
	public Country getCountryByCode(String code) {
				
		// Country to return. It will return null 
		// if the program does not find it
		Country c = null;
		
		// Connecting to DB
		DB_Connect db = new DB_Connect();
		
		// Querying the Database
		ResultSet rs = db.select("select * from country where code = '" + code + "';");
		
		try {
		
			// Looping over results
			while(rs.next()) {
				
				// NOTICE THIS TIME I DON'T NEED CODE
				//String code = rs.getString(1);
				String name = rs.getString(2);
				String continentString = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				// Converting the string to a ENUM
				Continent continent = null;
				if (continentString.equals("Asia")) {
					continent = Continent.ASIA;
				}
				else if (continentString.equals("Europe")) {
					continent = Continent.EUROPE;
				}
				else if (continentString.equals("North America")) {
					continent = Continent.NORTH_AMERICA;
				}
				else if (continentString.equals("Africa")) {
					continent = Continent.AFRICA;
				}
				else if (continentString.equals("Antarctica")) {
					continent = Continent.ANTARCTICA;
				}
				else if (continentString.equals("Oceania")) {
					continent = Continent.OCEANIA;
				}
				else if (continentString.equals("South America")) {
					continent = Continent.SOUTH_AMERICA;
				}
			
				// Creating the Country object using the builder
				c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build();
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// returning the list
		return c;

	}

	@Override
	public ArrayList<Country> getCountryByName(String nameSearch) {
		
		// List to return
		ArrayList<Country> list = new ArrayList<Country>();
		
		// Connecting to DB
		DataSource db = new DataSource();
		
		// Querying the Database
		ResultSet rs = db.select("SELECT * FROM country WHERE NAME LIKE '%" + nameSearch + "%'");
		
		try {
		
			// Looping over results
			while(rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continentString = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				// Converting the string to a ENUM
				Continent continent = null;
				if (continentString.equals("Asia")) {
					continent = Continent.ASIA;
				}
				else if (continentString.equals("Europe")) {
					continent = Continent.EUROPE;
				}
				else if (continentString.equals("North America")) {
					continent = Continent.NORTH_AMERICA;
				}
				else if (continentString.equals("Africa")) {
					continent = Continent.AFRICA;
				}
				else if (continentString.equals("Antarctica")) {
					continent = Continent.ANTARCTICA;
				}
				else if (continentString.equals("Oceania")) {
					continent = Continent.OCEANIA;
				}
				else if (continentString.equals("South America")) {
					continent = Continent.SOUTH_AMERICA;
				}
			
				// Creating the Country object using the builder
				Country c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build();
				
				// Adding object to the list
				list.add(c);

			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// returning the list
		return list;
	}

	@Override
	public boolean save(Country country) {
		
		// Connecting to DB
		DataSource db = new DataSource();
		
		// Getting data from the country object
		String code = country.getCode();
		String name = country.getName();
		Continent continent = country.getContinent();
		float surfaceArea = country.getSurfaceArea();
		String headOfState = country.getHeadOfState();
		
		String query = "INSERT INTO `world`.`country` (`Code`, `Name`, `Continent`, `SurfaceArea`, `HeadOfState`) VALUES ('" + code + "', '" + name + "', '" + continent.getName() + "', '" + surfaceArea + "', '" + headOfState + "')";
		
		// Querying the DB
		return db.save(query);
		
	}

}


