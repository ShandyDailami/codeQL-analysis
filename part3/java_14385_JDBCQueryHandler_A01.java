import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14385_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Use the connection...
            // For example, execute a SELECT query
            String sql = "SELECT * FROM mytable";
            //...

            // Close the connection
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}