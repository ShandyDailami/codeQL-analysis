import java.sql.*;

public class java_24527_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare the Statement
            statement = connection.createStatement();

            // Step 4: Execute the Query
            ResultSet resultSet = statement.executeQuery("SELECT password FROM Users");

            while (resultSet.next()) {
                String password = resultSet.getString("password");
                System.out.println("Password: " + password);
           
                // This is a security-sensitive operation related to injection.
                // However, in a real-world scenario, you should never print or store the password.
                // This is just for the purpose of the example.
                System.out.println("This is a security-sensitive operation related to injection.");
            }

            // Step 5: Close the Statement and Connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}