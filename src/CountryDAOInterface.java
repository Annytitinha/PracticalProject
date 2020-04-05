import java.util.ArrayList;
/**
 * 
 * @author Anaiana
 *
 */

public interface CountryDAOInterface {
	/**
	 * It gets the list of all countries in the database
	 * @return
	 */
    public ArrayList<Country> getAllCountires();
    
    /**
     * It gets a list of countries with the same name
     * @param name
     * @return
     */
    public ArrayList<Country> getCountriesByName(String name);
    /**
     * Get list of countries by code, returning only 1 result, as the code is unique
     * @param code
     * @return
     */
    public ArrayList<Country> getCountriesByCode(String code);
    /**
     * Add a country to the database
     * @param country
     * @return
     */
    public String insertNewCountry(Country country);
}