import java.sql.*;

public class java_07961_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM mytable WHERE mycolumn = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "somevalue");

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                System.out.println("Found a row: " + result.getString("mycolumn"));
            }

            // Step 6: Clean up
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}