import java.sql.*;

public class java_07390_JDBCQueryHandler_A08 {
    private Connection conn = null;

    public void connect(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            System.out.println("Disconnected from the database");
        } catch (SQLException e) {
            System.out.println("Failed to disconnect from the database");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String update) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Failed to execute update");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:your_database_url", "your_username", "your_password");

        ResultSet rs = handler.executeQuery("SELECT * FROM your_table");
        while (rs.next()) {
            // Do something with the result
        }

        handler.disconnect();
    }
}