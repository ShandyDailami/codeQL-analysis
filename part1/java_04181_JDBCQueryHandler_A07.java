import java.sql.*;

public class java_04181_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_04181_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.conn.createStatement().executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        this.conn.createStatement().executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

    public static void main(String[] args) {
        // In a real application, you would want to avoid hardcoding the database URL, username and password
        // Instead, use environment variables or configuration files
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myusername";
            String password = "mypassword";
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet rs = handler.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}