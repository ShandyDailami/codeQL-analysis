import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16195_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Load the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Use the connection to execute a query
        if (connection != null) {
            try {
                String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
                connection.prepareStatement(sql).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}