import java.sql.*;

public class java_04406_JDBCQueryHandler_A01 {
    // Define the URL, username and password for the database
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "user";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a Statement
            statement = connection.createStatement();

            // Create a new user
            String createUserQuery = "CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'newpassword'";
            statement.executeUpdate(createUserQuery);

            // Grant all privileges to the new user
            String grantPrivilegesQuery = "GRANT ALL PRIVILEGES ON mydb.* TO 'newuser'@'localhost'";
            statement.executeUpdate(grantPrivilegesQuery);

            // Step 3: Disconnect
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}