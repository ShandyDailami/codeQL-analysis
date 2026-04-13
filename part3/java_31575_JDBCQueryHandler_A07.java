import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31575_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1, "user1");

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (checkPassword(dbPassword)) {
                    System.out.println("Valid password");
                } else {
                    System.out.println("Invalid password");
                }
            } else {
                System.out.println("User not found");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean checkPassword(String dbPassword) {
        // Assuming the password hashing method is already implemented
        // You would need to implement this method based on your application's needs
        // This is a simplistic example and assumes the password is already hashed
        return true;
    }
}