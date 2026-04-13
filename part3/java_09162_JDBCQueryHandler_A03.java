import java.sql.*;

public class java_09162_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_09162_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public static void main(String[] args) {
        // Replace with your database URL, user and password
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, user, password);
            ResultSet rs = handler.executeQuery("SELECT * FROM my_table");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}