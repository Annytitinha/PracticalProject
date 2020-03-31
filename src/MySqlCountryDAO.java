
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public class MySqlCountryDAO implements CountryDAO {

		// METHOD 1: GET ALL CUSTOMERS
		@Override
		public ArrayList<Country> getCountry() {
			
			// CREATE THE ARRAYLIST TO PUT ALL THE CUSTOMERS
			// THAT ARE GOING TO BE RETURNED
			ArrayList<Country> country = new ArrayList<Country>();
			
			// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
			String query = "select * from country";
			
			// ACCESSING THE DATABASE
			DB_Connet db = new DB_Connet();
			
			// QUERYING THE DATABASE
			ResultSet rs = db.select(query);
			
			// LOOP OVER THE RESULT SET
			try {
				while( rs.next() ) {
					// FOR EACH ONE OF THE VALUES, WE WANT TO
					// GET THE ATTRIBTUES
					int Code = rs.getInt(1);
					String Name = rs.getString(2);
					String Continent = rs.getString(3);
					String SurfaceArea = rs.getString(4);
					String HeadOfState = rs.getString(5);
					
					country.add(new Country(Code, Name, Continent, SurfaceArea, HeadOfState));	
				}
				
				// CLOSING THE CONNECTION TO THE DATABASE
				db.closing();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// RETURN THE ARRAYLIST WITH ALL THE CUSTOMERS
			return country;
		}

		@Override
		public Country findCountryByCode(int Code) {
			
			// CREATING THE OBJECT THAT WE'RE GOING TO RETURN
			Country c = null;
			
			// THIS METHOD IS IN CHAGE OF CREATING THE QUERY
			String query = "select * from country where code = " + Code;
			
			// ACCESSING THE DATABASE
			DB_Connect db = new DB_Connet();
			
			// QUERYING THE DATABASE
			ResultSet rs = db.select(query);
			
			// WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE 
			// OF CUSTOMER
			try {
				rs.next();
				int Code = rs.getInt(1);
				String Name = rs.getString(2);
				String Continent = rs.getString(3);
				String SurfaceArea = rs.getString(4);
				String HeadOfState = rs.getString(5);
				c = new Country(Code, Name, Continent, SurfaceArea, HeadOfState);
				
				// CLOSING THE CONNECTION TO THE DATABASE
				db.closing();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// RETURN THE CUSTOMER 
			return c;
		}

		@Override
		public boolean saveCountry(Country country) {
			
			// ACCESSING THE DATABASE
			DB_Connet db = new DB_Connet();
			
			ResultSet rs;
			// FROM THE OBJECT, GETTING THE DATA
			int Code = rs.getInt(1);
			String Name = rs.getString(2);
			String Continent = rs.getString(3);
			String SurfaceArea = rs.getString(4);
			String HeadOfState = rs.getString(5);
			
			// THIS METHOD IS IN CHARGE OF CREATING THE QUERY
			String query = "insert into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + Name + "', '" + Continent + "', '" +SurfaceArea + "','" + HeadOfState+ "')";
			
			// REQUESTION TO SAVE THE DATA
			boolean result = db.save(query);
			
			// CLOSING THE DATABASE
			db.closing();
			
			return result;
		}

		

		

	}



