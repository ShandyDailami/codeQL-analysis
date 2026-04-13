import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_08908_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM USERS";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println("Username: " + username + ", Password: " + password);
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}