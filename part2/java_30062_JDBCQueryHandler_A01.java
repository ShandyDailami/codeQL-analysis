import java.sql.*;

public class java_30062_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database URL
        String username = "myusername"; // replace with your username
        String password = "mypassword"; // replace with your password

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Set the parameter value
            statement.setString(1, "user1"); // replace with the username you want to query

            // Step 5: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + user);
                System.out.println("Password: " + password);
            }

            // Step 7: Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}