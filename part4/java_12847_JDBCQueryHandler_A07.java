import java.sql.*;

public class java_12847_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE username = 'username' AND password = 'password'");

            // Step 4: Handle the result set
            while (resultSet.next()) {
                // Access the data
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Perform some operation with the data
                // ...
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}