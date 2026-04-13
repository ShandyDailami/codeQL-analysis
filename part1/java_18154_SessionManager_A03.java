import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18154_SessionManager_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a SQL query
            String sql = "CREATE TABLE Users (ID int PRIMARY KEY, Name varchar(255), Email varchar(255))";
            stmt.executeUpdate(sql);

            // Step 5: Clean up environment
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}