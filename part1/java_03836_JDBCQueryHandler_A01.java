import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03836_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create a PreparedStatement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE id = ?");
            statement.setInt(1, 123);

            // Step 4: Execute the PreparedStatement
            resultSet = statement.executeQuery();

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            if (resultSet != null) {
                try { resultSet.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { /* can't do anything */ }
            }
        }
    }
}