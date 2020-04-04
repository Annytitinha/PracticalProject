import java.sql.*;
import java.util.ArrayList;

public class CountryDAO implements CountryDAOInterface{

    @Override
    public ArrayList<Country> getAllCountires() {
        ResultSet res = null;
        ArrayList<Country> countryList = new ArrayList<Country>();
        try {
        	/**
        	 * aqui ele faz a conexao com banco de dados, fazendo a chamada da query
        	 */
            Connection dbConn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement query = dbConn.prepareStatement("SELECT * FROM country");
            res = query.executeQuery();
            while (res.next()){
            	/**
            	 * aqui ele cria um objeto pais e adiciona as variaveis dele, adicionando o na lista de paises
            	 */
                Country country = new Country();
                country.setCode(res.getString("Code"));
                country.setName(res.getString("Name"));
                country.setContinent(res.getString("Continent"));
                country.setSurfaceArea(res.getFloat("SurfaceArea"));
                country.setHeadOfState(res.getString("HeadOfState"));
                countryList.add(country);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            try {
                if(res != null)  res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return countryList;
    }

    @Override
    public ArrayList<Country> getCountriesByName(String countryName) {
        ResultSet res = null;
        ArrayList<Country> countryList = new ArrayList<Country>();
        try {
        	/**
        	 * nessa funcao ele verifica quais os paises tem nomes parecidos
        	 */
            Connection dbConn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement query = dbConn.prepareStatement("SELECT * FROM country WHERE Name LIKE '%" + countryName + "%'");
            res = query.executeQuery();
            while (res.next()){
                Country country = new Country();
                country.setCode(res.getString("Code"));
                country.setName(res.getString("Name"));
                country.setContinent(res.getString("Continent"));
                country.setSurfaceArea(res.getFloat("SurfaceArea"));
                country.setHeadOfState(res.getString("HeadOfState"));
                countryList.add(country);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            try {
                if(res != null)  res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return countryList;
    }

    @Override
    public ArrayList<Country> getCountriesByCode(String countryCode) {
        ArrayList<Country> countryList = new ArrayList<Country>();
        ResultSet res = null;
        try {
        	/**
        	 * pegar o pais pelo codigo
        	 */
            Connection dbConn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement query = dbConn.prepareStatement("SELECT * FROM country WHERE Code LIKE '%" + countryCode + "%'");
            res = query.executeQuery();
            while (res.next()){
                Country country = new Country();
                country.setCode(res.getString("Code"));
                country.setName(res.getString("Name"));
                country.setContinent(res.getString("Continent"));
                country.setSurfaceArea(res.getFloat("SurfaceArea"));
                country.setHeadOfState(res.getString("HeadOfState"));
                countryList.add(country);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            try {
                if(res != null)  res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return countryList;
    }

    @Override
    public String insertNewCountry(Country country) {
        ResultSet res = null;
        String latestCode = "";
        try {
        	/**
        	 * Fazemos a query , para cada interrogacao , um dado a ser adicionado.
        	 * quando o resultado eh uma linha afetada, ele vai retornar o codigo do pais inserido, caso nao tenha linha afetada , ele vai dar erro e vai vol
        	 * voltar em branco com uma mensagem de erro no servidor
        	 */
            Connection dbConn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement query = dbConn.prepareStatement(
                    "INSERT INTO country(Code, Name, Continent, SurfaceArea, HeadOfState) " +
                            "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, country.getCode());
            query.setString(2, country.getName());
            query.setString(3, country.getContinent());
            query.setFloat(4, country.getSurfaceArea());
            query.setString(5, country.getHeadOfState());
            int rowAffected = query.executeUpdate();
            if(rowAffected == 1){
                latestCode = country.getCode();
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        finally {
            try {
                if(res != null)  res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return latestCode;
    }
}