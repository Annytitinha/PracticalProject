import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/**
	 * @Anaiana
	 * Using singleton design pattern to connect with the database
	 */
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://52.50.23.197:3306/world";
    private String username = "cctstudent";
    private String password = "Pass1234!";
    private DatabaseConnection(){
        try {
        	// get connection with the database
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

 //Access point to the unique instance of the singleton
    public Connection getConnection() {
        return connection;
    }
//Access point to the unique instance of the singleton
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}