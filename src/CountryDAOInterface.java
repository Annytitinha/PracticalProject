import java.util.ArrayList;

public interface CountryDAOInterface {
	/**
	 * Eh para pegar a lista de todos ospaises no banco de dados
	 * @return
	 */
    public ArrayList<Country> getAllCountires();
    
    /**
     * para pegar uma lista de paises com o mesmo nome
     * @param name
     * @return
     */
    public ArrayList<Country> getCountriesByName(String name);
    /**
     * lista de paises pelo codigo, retornando apenas 1 resultado, pois o codigo eh unico
     * @param code
     * @return
     */
    public ArrayList<Country> getCountriesByCode(String code);
    /**
     * para adicionar um pais no banco de dados
     * @param country
     * @return
     */
    public String insertNewCountry(Country country);
}