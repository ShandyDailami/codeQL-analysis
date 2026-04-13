import java.sql.*;

public class java_06054_JDBCQueryHandler_A03 {
    private Connection conn = null;

    public java_06054_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    public static void main(String[] args) {
        // You can use try-with-resources to make sure the connection gets closed after use
        try (JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            handler.executeQuery("SELECT * FROM myTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}