import java.util.ArrayList;
/**
 * 
 * @author Anaiana
 * Factory
 */

public interface CountryDAOInterface {
	/**
	 *@return all countries in the database
	 */
    public ArrayList<Country> getAllCountires();
    
    /**
     * It gets a list of countries with the same name
     * @param name
     * @return name
     */
    public ArrayList<Country> getCountriesByName(String name);
    /**
     * Get list of countries by code, returning only 1 result, as the code is unique
     * @param code
     * @return code
     */
    public ArrayList<Country> getCountriesByCode(String code);
    /**
     * Add a country to the database
     * @param country
     * @return country
     */
    public String insertNewCountry(Country country);
}