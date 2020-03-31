import java.util.List;



public interface CountryDAO {
	public void save(Country country);

	public List<Country> list();

	public List<Country> listByContinent(Integer Code);

}
