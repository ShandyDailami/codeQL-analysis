import java.sql.*;

public class java_31332_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            statement = connection.createStatement();

            // Step 4: Execute a SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 6: Close the ResultSet and Statement
            resultSet.close();
            statement.close();

            // Step 7: Close the Connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}