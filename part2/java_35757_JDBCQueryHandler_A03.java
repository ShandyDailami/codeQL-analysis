import java.sql.*;

public class java_35757_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            statement = connection.createStatement();

            // Execute the SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}