import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class java_19920_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName(DRIVER);

            // Step 2: Create a connection
            connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Create a statement
            String sql = "SELECT password FROM Users WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "user1");

            // Step 4: Execute the statement
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                String enteredPassword = "password"; // This should be the password entered by the user

                // Step 5: Verify the entered password
                if (isPasswordValid(dbPassword, enteredPassword)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid password!");
                }
            } else {
                System.out.println("No user found!");
            }

            // Step 6: Clean up
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPasswordValid(String dbPassword, String enteredPassword) {
        // In a real application, you would probably want to use a more secure method to compare passwords
        // This is just a simple example
        return dbPassword.equals(enteredPassword);
    }
}