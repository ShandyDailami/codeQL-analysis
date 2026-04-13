import java.sql.*;

public class java_03350_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Define a SQL query
            String query = "SELECT * FROM users WHERE role = 'admin'";

            // Step 3: Prepare the statement for execution
            Statement statement = connection.createStatement();

            // Step 4: Execute the SQL query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}