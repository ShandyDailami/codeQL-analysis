import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_31881_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_31881_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        password = Base64.getEncoder().encodeToString(hash);
    }

    public boolean login(String username, String password) throws SQLException {
        hashPassword(password);

        String query = "SELECT * FROM Users WHERE Username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("Password");
            return password.equals(dbPassword);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            new JDBCQueryHandler(url, username, password).login("myuser", "mypassword");
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}