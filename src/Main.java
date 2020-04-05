import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * 
 * @author Anaiana
 * https://github.com/Annytitinha/PracticalProject
 *
 */

public class Main {
	//Method to get input from the user
	private int input = 0;
	private BufferedReader bufferedReader;

	private Main() {
		//InputStream in.
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		do {
			system();
		} while (input != 5);
	}
	//menu options
	private void system() {
		
		System.out.println("\nCountry List Application\n");
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press 1 - List all countries");
		System.out.println("Press 2 - Find country by code");
		System.out.println("Press 3 - Find country by name");
		System.out.println("Press 4 - Add a new country");
		System.out.println("Press 5 - Exit");
		try {
			input = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		functions(input);
	}

	private void functions(int input) {
		if (input == 1) {
			// Getting all the countries in the database
			ArrayList<Country> countryList = new ArrayList<>();
			CountryDAO countryDAO = new CountryDAO();
			countryList = countryDAO.getAllCountires();
			for (Country country : countryList) {
				System.out.println("Code: " + country.getCode());
				System.out.println("Name: " + country.getName());
				System.out.println("Continent: " + country.getContinent());
				System.out.println("Surface area: " + country.getSurfaceArea());
				System.out.println("Head of state: " + country.getHeadOfState());
				System.out.println();
			}
		}
		if (input == 2) {
			System.out.println("Enter a code");
			// Getting the countries by code in the database
			ArrayList<Country> countryList = new ArrayList<>();
			try {
				String code = bufferedReader.readLine();
				CountryDAO countryDAO = new CountryDAO();
				countryList = countryDAO.getCountriesByCode(code);
				for (Country country : countryList) {
					System.out.println("Code: " + country.getCode());
					System.out.println("Name: " + country.getName());
					System.out.println("Continent: " + country.getContinent());
					System.out.println("Surface area: " + country.getSurfaceArea());
					System.out.println("Head of state: " + country.getHeadOfState());
					System.out.println();
				}
			} catch (Exception error) {
				error.printStackTrace();
			}
		}

		if (input == 3) {
			System.out.println("Enter a name");
			// Getting the countries by name in the database
			ArrayList<Country> countryList = new ArrayList<>();
			try {
				String name = bufferedReader.readLine();
				CountryDAO countryDAO = new CountryDAO();
				countryList = countryDAO.getCountriesByName(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Country country : countryList) {
				System.out.println("Code: " + country.getCode());
				System.out.println("Name: " + country.getName());
				System.out.println("Continent: " + country.getContinent());
				System.out.println("Surface area: " + country.getSurfaceArea());
				System.out.println("Head of state: " + country.getHeadOfState());
				System.out.println();
			}
		}
		if (input == 4) {
			CountryDAO countryDAO = new CountryDAO();
			Country newCountry = new Country();
			int continentInput = 0;
			String res = "";
			try {
				
				 //To insert a new country, for each line the user will add a data 
				 //in the fifth line option it selects the continent according to the menu option.
				 
				System.out.println("Enter a code");
				newCountry.setCode(bufferedReader.readLine());
				System.out.println("Enter a Name");
				newCountry.setName(bufferedReader.readLine());
				System.out.println("Enter a Head Of State");
				newCountry.setHeadOfState(bufferedReader.readLine());
				System.out.println("Enter a Surface Area");
				newCountry.setSurfaceArea(Float.parseFloat(bufferedReader.readLine()));
				System.out.println("\nSelect one Continent of the List\n");
				System.out.println("Press 1 - Asia");
				System.out.println("Press 2 - Europe");
				System.out.println("Press 3 - North America");
				System.out.println("Press 4 - Africa");
				System.out.println("Press 5 - Oceania");
				System.out.println("Press 6 - Antarctica");
				System.out.println("Press 7 - South America");
				continentInput = Integer.parseInt(bufferedReader.readLine());
				if (continentInput == 1){
					newCountry.setContinent("Asia");
				}else if(continentInput == 2){
					newCountry.setContinent("Europe");
				}else if(continentInput == 3){
					newCountry.setContinent("North America");
				}else if(continentInput == 4){
					newCountry.setContinent("Africa");
				}else if(continentInput == 5){
					newCountry.setContinent("Oceania");
				}else if(continentInput == 6){
					newCountry.setContinent("Antarctica");
				}else if(continentInput == 7){
					newCountry.setContinent("South_America");
				}else{
					System.out.println("ERROR: You not selected a correct value for Continent!");
					return;
				}

				res = countryDAO.insertNewCountry(newCountry);
				System.out.println(res != "" ? "New country inserted, the new code is "+res : "Something went wrong");

			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {

		new Main();
	}
}
