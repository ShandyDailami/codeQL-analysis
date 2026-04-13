import java.sql.*;

public class java_13921_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a Query
            String query = "SELECT * FROM users WHERE role='admin'";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Role: " + role);
            }

            // Step 6: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}