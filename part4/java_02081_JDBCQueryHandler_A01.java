import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class java_02081_JDBCQueryHandler_A01 {
    private static Connection conn = null;

    static Connection connectToDatabase() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error in finding the driver: " + e.getMessage());
        }

        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database successfully!");

        return conn;
    }

    static boolean isPasswordValid(String password) {
        String hashedPassword = getPasswordHash(password);
        return getPasswordHash(password).equals(hashedPassword);
    }

    static String getPasswordHash(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashInBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashInBytes.length; i++)
            sb.append(Integer.toString((hashInBytes[i] & 0xff) + 0x100, 16).substring(1));

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            connectToDatabase();

            String query = "SELECT * FROM Users";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                if (isPasswordValid(password)) {
                    System.out.println("Access granted for user: " + username);
                } else {
                    System.out.println("Access denied for user: " + username);
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}