import java.sql.*;

public class java_16047_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_16047_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
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
}