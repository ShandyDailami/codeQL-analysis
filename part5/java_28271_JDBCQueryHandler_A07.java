import java.sql.*;

public class java_28271_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_28271_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password");

            // Example of querying data
            ResultSet rs = handler.executeQuery("SELECT * FROM your_table");
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}