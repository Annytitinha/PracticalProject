import java.util.ArrayList;



public interface CountryDAO {
	
	public ArrayList<Country> getCountry();
	public Country findCoutryrByCode(int code);
	public boolean saveCustomer(Country country);
}
