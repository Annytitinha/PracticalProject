import java.util.ArrayList;

public interface CountryDAOInterface {
    public ArrayList<Country> getAllCountires();
    public ArrayList<Country> getCountriesByName(String name);
    public ArrayList<Country> getCountriesByCode(String code);
    public String insertNewCountry(Country country);
}