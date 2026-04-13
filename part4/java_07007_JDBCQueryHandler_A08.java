import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_07007_JDBCQueryHandler_A08 {

    public static void main(String[] args) {

        // Step 1: Establish a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 2: Prepare a statement
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Execute the statement
        try {
            statement.setString(1, "testuser");
            statement.setString(2, "password");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 4: Clean up resources
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}