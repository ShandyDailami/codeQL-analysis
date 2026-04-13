import java.sql.*;

public class java_24574_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL query
            String query = "SELECT * FROM mytable WHERE mycolumn = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "somevalue");

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                System.out.println("Found record: " + result.getString("mycolumn"));
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}