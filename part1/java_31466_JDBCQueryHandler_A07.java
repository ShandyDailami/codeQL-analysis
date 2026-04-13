import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31466_JDBCQueryHandler_A07 {

    // This is a security-sensitive operation. This method will try to authenticate the user.
    public boolean authenticateUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "username";
        String pass = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}