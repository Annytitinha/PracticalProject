
public class Country {
	private int Code;
	private String Name;
	private String Continent;
	private String SurfaceArea;
	private String HeadOfState;
	
	public void Countryr(int Code, String Name, String Continent, String SurfaceArea, String HeadOfState) {
		this.Code = Code;
		this.Name = Name;
		this. Continent = Continent;
		this.SurfaceArea = SurfaceArea;
		this.HeadOfState = HeadOfState;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int Code) {
		this.Code = Code;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String Continent) {
		this.Continent = Continent;
	}

	public String getSurfaceArea() {
		return SurfaceArea;
	}

	public void setSurfaceArea(String SurfaceArea) {
		this.SurfaceArea = SurfaceArea;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}

	public void setHeadOfState(String HeadOfState) {
		this.HeadOfState = HeadOfState;
	}
	
	@Override
	public String toString() {
		return "Code: " + Code + " Name: " + Name + " Continent: " + Continent + " SurfaceArea: " + SurfaceArea + "HeadOfState: "+ HeadOfState;
	}

}
