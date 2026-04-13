import java.sql.*;

public class java_35186_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Example of a security-sensitive operation
            String sql = "SELECT * FROM Users WHERE Password = 'password'";
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String username = result.getString("Username");
                String password = result.getString("Password");
                System.out.println("Username: " + username);
           
                // This is a security-sensitive operation, no further actions required.
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database: " + e.getMessage());
        }
    }
}