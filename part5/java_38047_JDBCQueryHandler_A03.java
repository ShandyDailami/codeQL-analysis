import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38047_JDBCQueryHandler_A03 {
    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/testdb";
    private String username = "root";
    private String password = "password";

    // Constructor
    public java_38047_JDBCQueryHandler_A03() {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java driver not found!");
        }
    }

    // Method to open a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try {
            ResultSet rs = handler.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}