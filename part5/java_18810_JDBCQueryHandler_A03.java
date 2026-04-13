import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18810_JDBCQueryHandler_A03 {

    // A method to connect to the database
    public Connection getConnection() {
        Connection conn = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // A method to close the connection
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // A method to perform a query
    public void performQuery(Connection conn, String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Print the result
                System.out.println(rs.getString("column_name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        Connection conn = jdbcQueryHandler.getConnection();
        jdbcQueryHandler.performQuery(conn, "SELECT * FROM my_table");
    }
}