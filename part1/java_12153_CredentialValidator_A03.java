import java.sql.*;

public class java_12153_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "password";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'");

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}