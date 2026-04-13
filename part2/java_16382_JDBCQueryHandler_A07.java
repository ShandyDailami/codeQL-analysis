import java.sql.*;

public class java_16382_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_16382_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // replace with your actual database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // for example, execute a query
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}