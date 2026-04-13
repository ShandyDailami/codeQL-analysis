import java.sql.*;

public class java_18682_JDBCQueryHandler_A01 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Define the SQL query
            String query = "SELECT sensitive_data FROM sensitive_table WHERE condition";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String sensitiveData = resultSet.getString("sensitive_data");
                // Perform some operation with the sensitive data, e.g., display it
                System.out.println("Sensitive data: " + sensitiveData);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error accessing the database: " + e.getMessage());
        }
    }
}