import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26537_SessionManager_A03 {
    private static SessionManager instance = null;

    private Connection connection = null;
    private Statement stmt = null;

    private java_26537_SessionManager_A03() {
        try {
            // Step 1: Load the database driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the database connection.
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Create a statement object.
            this.stmt = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void performOperation() {
        try {
            // Step 4: Execute a simple SQL statement.
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Step 5: Process the result set.
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 6: Clean up the statement and connection.
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}