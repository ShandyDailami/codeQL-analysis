import java.sql.*;

public class java_21515_JDBCQueryHandler_A03 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a query
            String query = "SELECT * FROM employees WHERE first_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "John");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("first_name"));
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}