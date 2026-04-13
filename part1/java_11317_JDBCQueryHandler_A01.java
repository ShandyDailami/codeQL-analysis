import java.sql.*;

public class java_11317_JDBCQueryHandler_A01 {
    // Define the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Define the SQL query
    private static final String SQL_QUERY = "SELECT * FROM Users WHERE username = ?";

    public static void main(String[] args) {
        try {
            // Load the driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(SQL_QUERY);

            // Set the parameter value
            statement.setString(1, "admin");

            // Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}