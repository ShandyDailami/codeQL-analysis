import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29676_JDBCQueryHandler_A07 {

    public static void main(String[] args) {

        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java driver not found.");
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Unable to get connection to database.");
            e.printStackTrace();
        }

        // Step 3: Execute a query
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("User found in database");
                }
            } catch (SQLException e) {
                System.out.println("Unable to execute query.");
                e.printStackTrace();
            }
        }
    }
}