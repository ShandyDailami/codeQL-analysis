import java.sql.*;

public class java_16595_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM your_table"; // replace with your actual SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Process the result set here
                // For example, print the values of each column
                System.out.println(resultSet.getString("column1") + ", " +
                                   resultSet.getString("column2") + ", " +
                                   // Add more columns as necessary
                                   );
           
                // Check integrity here
                // If the integrity check fails, throw an exception
                if (/*integrity check fails*/) {
                    throw new IntegrityFailureException("Integrity check failed.");
                }
            }
        } catch (SQLException | IntegrityFailureException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class IntegrityFailureException extends Exception {
    public java_16595_JDBCQueryHandler_A08(String message) {
        super(message);
    }
}