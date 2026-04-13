import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03125_JDBCQueryHandler_A01 {

    // Step 1: Establish a Connection
    private Connection establishConnection() throws SQLException {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    // Step 2: Execute a Query
    public void executeQuery(String query) throws SQLException {
        Connection connection = establishConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Step 3: Handle the Result Set
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }

        // Step 4: Clean Up
        resultSet.close();
        statement.close();
        connection.close();
    }

    // Step 5: Main Method
    public static void main(String[] args) throws SQLException {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
    }
}