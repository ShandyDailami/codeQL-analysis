import java.sql.*;

public class java_08518_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_08518_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
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

    public static void main(String[] args) {
        // Replace with your own credentials
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        ResultSet rs = handler.executeQuery("SELECT * FROM your_table");

        // Process the ResultSet (e.g., printing each row)
        while (rs.next()) {
            System.out.println(rs.getString("your_column"));
        }

        handler.closeConnection();
    }
}