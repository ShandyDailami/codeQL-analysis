import java.sql.*;

public class java_31046_JDBCQueryHandler_A07 {
    private Connection conn;

    // constructor
    public java_31046_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}

// usage example:
public class Main {
    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "your_username", "your_password");
            
            ResultSet rs = handler.executeQuery("SELECT * FROM your_table");
            
            while (rs.next()) {
                System.out.println(rs.getString("your_column_name"));
            }
            
            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}