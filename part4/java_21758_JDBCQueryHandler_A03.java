import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21758_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "username",
                    "password");

            // Step 3: Perform a secure operation involving injection
            String injectionSafeQuery = "INSERT INTO users(username, password) VALUES ('testUser', '" + connection + "')";
            connection.createStatement().executeUpdate(injectionSafeQuery);

            // Step 4: Disconnect from the database
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}