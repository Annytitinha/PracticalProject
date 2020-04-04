mport java.sql.*;
import java.util.ArrayList;

public class CountryDAO implements CountryDAOInterface{

    @Override
    public ArrayList<Country> getAllCountires() {
        ResultSet res = null;
        ArrayList<Country> countryList = new ArrayList<Country>();
        try {
            Connection dbConn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement query = dbConn.prepareStatement("SELECT * FROM country");
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
    public ArrayList<Country> getCountriesByName(String countryName) {
        ResultSet res = null;
        ArrayList<Country> countryList = new ArrayList<Country>();
        try {
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