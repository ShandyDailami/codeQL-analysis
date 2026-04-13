import java.sql.*;

public class java_25886_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Execute a query
            String query = "SELECT * FROM mytable WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "John"); // This is our parameter

            ResultSet result = statement.executeQuery();

            // Step 4: Process the result
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}