import java.sql.*;

public class java_31446_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            statement = connection.createStatement();

            // Step 4: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + 123);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Step 6: Close the Statement and Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}