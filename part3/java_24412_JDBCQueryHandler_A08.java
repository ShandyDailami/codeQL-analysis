import java.sql.*;

public class java_24412_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Open a Statement
            statement = connection.createStatement();

            // Step 4: Execute a SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Step 6: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}