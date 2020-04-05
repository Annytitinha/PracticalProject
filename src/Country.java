
public class Country {
	// Country's Code CHAR(3)
	private String code;
	// Country's Name
	private String name;
	// Continent where the Country is
	private String continent;
	// Surface Area of the country in km2
	private float surfaceArea;
	// The Head of State's name
	private String headOfState;

	public Country() {
	}
	/**
	 * 
	 * @param code
	 * @param name
	 * @param continent
	 * @param surfaceArea
	 * @param headOfState
	 */
	
	public Country(String code, String name, String continent, float surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}
	/**
	 * @return name
	 */

	public String getCode() {
		return code;
	}
	/**
	 * 
	 * @param code
	 */

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	 * @return name
	 */
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return continent
	 */

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	/**
	 * 
	 * @return SurfaceArea
	 */

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	/**
	 * 
	 * @return headOfState;
	 */
	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
	@Override
	public String toString() {
		return "CODE: " + code + " NAME: " + name + " CONTINENT: " + continent + " SURFACE AREA: " + surfaceArea + "HEAD OF STATE: "+ headOfState;
	}

}