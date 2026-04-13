import java.sql.*;
import org.mindrot.jbcrypt.*;

public class java_07745_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String passwordToHash = "password";

            // Create a hashed password
            String hashedPassword = BCrypt.hashpw(passwordToHash, BCrypt.gensalt());

            System.out.println(hashedPassword);

            String selectSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setString(1, "user1");
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                String dbPassword = rs.getString("password");
                if (BCrypt.checkpw(passwordToHash, dbPassword)) {
                    System.out.println("Password is correct");
                } else {
                    System.out.println("Password is incorrect");
                }
            }
            rs.close();
            selectStmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}