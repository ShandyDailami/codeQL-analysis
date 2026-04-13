import java.sql.*;

public class java_28563_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //Step 2: Prepare the SQL query
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            //Step 3: Set the parameters and execute the query
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");
            ResultSet result = statement.executeQuery();

            //Step 4: Process the result
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            //Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}