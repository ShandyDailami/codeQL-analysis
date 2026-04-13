import java.sql.*;

public class java_00904_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String passwordDb = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, user, passwordDb);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'");

            // Step 4: Check if the query returned any rows
            if (resultSet.isBeforeFirst()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}