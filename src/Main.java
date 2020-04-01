import java.util.ArrayList;

public class Main {
	
public static void main(String[] args) {
		
		// NOW THE CLIENT DOES NOT HAVE ANYTHING TO DO
		// THE THE DATABASE CLASS. 
		// THE CLIENT WILL ONLY TALK TO THE CUSTOMERDAO
		// IN TERMS OF CUSTOMER
		// IN OTHER WORDS, THE PASSING OF DATA IS GOING 
		// TO BE CUSTOMERS OBJECTS
		CountryDAO db = new MySQLCountryDAO();
		
		// GETTING ALL OF THE CUSTOMERS IN THE DATABASE
		ArrayList<Country> country = db.getCountry();
		
		// PRINTING THEM TO THE CONSOLE
		for (Country c : country) {
			System.out.println(c);
		}
		
		// GETTING ONLY THE CUSTOMER THAT HAS THE GIVEN
		// ID
		Country c = db.findCountryByCode(2);
		
		// PRINTING IT TO THE CONSOLE
		System.out.println(c);
		
		// CREATING A NEW CUSTOMER. KEEP IN MIND THAT
		// THE ID OF THE NEW CUSTOMER IS GOING TO BE THE
		// SIZE OF THE ARRAY PLUS ONE
		Country newCountry = new Country(country.size() + 1, "Amilcar", "Bilolilo", "Heaven", "Bumby");
		
		// ADDING THE CUSTOMER TO THE ARRAY, TO HAVE LOCAL
		// CONTROL OF THE DATA
		country.add(newCountry);
		// ADDING THE NEW CUSTOMER INTO THE DATABASE
		System.out.println(db.saveCountry(newCountry));

	}
		
}


