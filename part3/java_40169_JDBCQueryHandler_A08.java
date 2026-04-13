import java.sql.*;

public class java_40169_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName(DRIVER).newInstance();

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'admin' AND password = 'password'");

            // Handle the security-sensitive operations related to integrity failure
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("No user found!");
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}