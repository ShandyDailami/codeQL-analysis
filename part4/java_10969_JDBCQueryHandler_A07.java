import java.sql.*;

public class java_10969_JDBCQueryHandler_A07 {

    public boolean authenticate(String username, String password) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "username";
        String pass = "password";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + username + "' and password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return true; // Authentication successful
            } else {
                return false; // Authentication failed
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}