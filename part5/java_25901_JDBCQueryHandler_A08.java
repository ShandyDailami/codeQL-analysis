import java.sql.*;

public class java_25901_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the Query
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the Parameter Value
            statement.setInt(1, 1); // for example

            // Step 4: Execute the Query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the Result
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 6: Close the Connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}