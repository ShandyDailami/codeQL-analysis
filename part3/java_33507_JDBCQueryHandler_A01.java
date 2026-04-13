import java.sql.*;

public class java_33507_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            String query = "CREATE TABLE sensitive_data (id INT, name VARCHAR(100), password VARCHAR(100))";
            statement.executeUpdate(query);

            String insertQuery = "INSERT INTO sensitive_data VALUES (1, 'admin', 'password')";
            statement.executeUpdate(insertQuery);

            String selectQuery = "SELECT * FROM sensitive_data";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("password: " + resultSet.getString("password"));
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}