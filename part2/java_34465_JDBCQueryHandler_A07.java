import java.sql.*;

public class java_34465_JDBCQueryHandler_A07 {
    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String username = "root";
    private String password = "password";

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.jdbc.Driver";

    // Constructor
    public java_34465_JDBCQueryHandler_A07() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Open a connection
    public Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query
    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        Connection conn = openConnection();
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Execute a non-query (insert, update, delete)
    public int executeNonQuery(String query) {
        Statement stmt = null;
        Connection conn = openConnection();
        int rows = 0;
        try {
            stmt = conn.createStatement();
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // Close the connection
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM my_table";
        ResultSet rs = handler.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }

        handler.closeConnection(handler.openConnection());
    }
}