import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13354_JDBCQueryHandler_A01 {

    // This method establishes a connection to the database.
    private Connection getConnection() {
        Connection conn = null;
        try {
            // This is a placeholder, replace with your actual database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";

            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // This method executes a SQL query and closes the connection.
    private void executeQuery(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // This is a placeholder, replace with your actual query
            String sql = "SELECT * FROM Users";

            ResultSet rs = stmt.executeQuery(sql);

            // This loop will print the results of the query
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // The main method, which calls the methods to establish a connection and execute a query.
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection conn = handler.getConnection();
        handler.executeQuery(conn);
    }
}