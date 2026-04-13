import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41874_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        Connection conn = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, username, password);

            // Perform some operations here
            // Example: select all from table
            String sql = "SELECT * FROM users";
            conn.createStatement().executeQuery(sql);

            // Close connection
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}