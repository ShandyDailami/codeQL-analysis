import java.sql.*;

public class java_15820_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_15820_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void update(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Replace with your actual database URL, username, and password
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

        // Example: Update a user
        handler.update("UPDATE users SET password = 'new_password' WHERE username = 'username'");

        // Example: Select a user
        ResultSet rs = handler.select("SELECT * FROM users WHERE username = 'username'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    System.out.println(rs.getString("password"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}