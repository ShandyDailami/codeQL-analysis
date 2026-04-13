import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03800_JDBCQueryHandler_A01 {

    private Connection conn;
    private Statement stmt;

    public void connect(String dbURL, String userName, String password) {
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a Connection
            conn = DriverManager.getConnection(dbURL, userName, password);

            // Create a Statement
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Execute a Query
            ResultSet rs = stmt.executeQuery(query);

            // Print the ResultSet
            while (rs.next()) {
                System.out.println("Result: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost/test", "root", "password");
        handler.executeQuery("SELECT username FROM users WHERE username = 'admin' AND password = 'password'");
    }
}