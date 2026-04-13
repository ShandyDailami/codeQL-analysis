import java.sql.*;
import java.util.Base64;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class java_10811_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myUser";
    private static final String PASSWORD = "myPassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Sample query
            String query = "SELECT * FROM users WHERE username = ?";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                // Hash password using Bcrypt
                String hashedPassword = hashPassword(password);

                // Generate JWT
                JwtBuilder builder = Jwts.builder();
                builder.setSubject(username);
                builder.claim("role", role);
                String token = builder.signWith(SignatureAlgorithm.HS256, hashedPassword).compact();

                System.out.println("Token: " + token);
           
                // Further operations with token...
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try { stmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
        }
    }

    private static String hashPassword(String password) {
        String salt = "salt"; // You should store this somewhere securely
        String hash = BCrypt.hashpw(password + salt, BCrypt.gensalt(12));
        return hash;
    }
}