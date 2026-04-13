import java.sql.*;

public class java_10925_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_10925_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            // You can use a real URL, username, and password
            // Here I'm using a placeholder for simplicity
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "username";
            String password = "password";

            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

            ResultSet rs = handler.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}