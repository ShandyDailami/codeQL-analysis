import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03982_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_03982_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void processUsers() throws SQLException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        String selectQuery = "SELECT * FROM users";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        while (rs.next()) {
            String password = rs.getString("password");
            String hashedPassword = hashPassword(password);

            if (hashedPassword.equals(password)) {
                System.out.println("User found: " + rs.getString("username"));
            }
        }

        rs.close();
        stmt.close();
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        byte[] hash = MessageDigest.getInstance("MD5").digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try {
            new JDBCQueryHandler(url, username, password).processUsers();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}