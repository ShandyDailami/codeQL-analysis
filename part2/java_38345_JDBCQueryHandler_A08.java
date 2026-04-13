import java.sql.*;

public class java_38345_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // Main method
    public static void main(String[] args) {
        try {
            checkIntegrity();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for checking the integrity
    public static void checkIntegrity() throws SQLException {
        // Create a connection
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        // Prepare statement
        Statement statement = connection.createStatement();

        // Check table existence
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        while (resultSet.next()) {
            String tableName = resultSet.getString(1);
            System.out.println("Table name: " + tableName);

            // Check table integrity
            ResultSet tableResultSet = statement.executeQuery("SELECT * FROM " + tableName);
            while (tableResultSet.next()) {
                System.out.println("Data in table: " + tableResultSet.getString(1));
            }
        }

        // Close connection
        connection.close();
    }
}