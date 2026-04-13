import java.sql.*;

public class java_03970_JDBCQueryHandler_A07 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Users WHERE id = '" + args[0] + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
           
                if (username.equals(args[0]) && password.equals(args[1])) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Authentication failed.");
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}