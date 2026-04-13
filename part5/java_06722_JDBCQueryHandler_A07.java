import java.sql.*;

public class java_06722_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection conn;

    public java_06722_JDBCQueryHandler_A07() {
        connectToDB();
    }

    private void connectToDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM users");

        try {
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // handle username and password here, possibly with encryption and hashing
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}