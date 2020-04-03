import java.util.ArrayList;



public interface CountryDAO {
	
	public ArrayList<Country> getCountry();
	public Country getCountryByCode(int code);
	public boolean saveCountry(Country country);
	public ArrayList<Country> getCountryByName(String name);
	
}
