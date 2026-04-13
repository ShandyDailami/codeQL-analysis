import java.sql.*;

public class java_26369_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myUser";
    private static final String password = "myPassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
            }

            // Step 4: Close the connection
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}