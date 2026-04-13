import java.sql.*;

public class java_26284_JDBCQueryHandler_A03 {
    private static String url;
    private static String username;
    private static String password;

    static {
        url = "jdbc:mysql://localhost:3306/db"; // Replace with your database URL
        username = "root"; // Replace with your username
        password = "password"; // Replace with your password
    }

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM table"; // Replace with your query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // Do something with column1
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}