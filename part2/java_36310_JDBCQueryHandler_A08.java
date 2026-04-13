import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36310_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a new statement
            statement = connection.createStatement();

            // Execute a query
            String sql = "SELECT * FROM my_table";
            statement.executeUpdate(sql);

            // Close the connection and statement
            statement.close();
            connection.close();

            System.out.println("Connection and statement closed successfully.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}