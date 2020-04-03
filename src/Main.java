import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountryDAO db = new MySQLCountryDAO();
		
		// Using first method
		ArrayList<Country> countries = db.getCountrieis();
		
		for (Country c : countries) {
			System.out.println(c);
		}
		
		// Using second method
		Country country = db.getCountryByCode("VEN");
		System.out.println(country);
		
		// Using third Method
		ArrayList<Country> countries2 = db.getCountryByName("republic");
		
		for (Country c : countries2) {
			System.out.println(c);
		}
		
		// Using the fourth method 
		Country brasil = new Country.CountryBuilder("BRA", "Republic of Brazil", Continent.SOUTH_AMERICA, 200f, "Lula").build();
		boolean result = db.save(brasil);

		Country ireland = new Country.CountryBuilder("IRE", "Republic of Ireland",Continent.EUROPE, 50f,"Leo Varadkar").builder();
		boolean result = db.save(ireland);

		Country japan = new Country.CountryBuilder("JAP", "Japan", Continent.ASIA, 100f, "Hisamitsu").builder();
		boolean result = db.save(japan);
		
		System.out.println(result);
		
		
	}

}
