import java.sql.*;

public class java_32568_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_32568_JDBCQueryHandler_A07(String dbURL, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");
        while (rs.next()) {
            System.out.println("User found!");
        }
        handler.closeConnection();
    }
}