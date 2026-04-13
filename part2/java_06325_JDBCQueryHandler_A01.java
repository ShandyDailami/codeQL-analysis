import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_06325_JDBCQueryHandler_A01 {

    private static final String URL = "your_database_url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load driver for database
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Open a new statement
            Statement stmt = conn.createStatement();

            // Use a secure random generator for password hashing
            SecureRandom sr = new SecureRandom();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String password = new String(new char[10]).replace('\0', 'a');

            // Hashing password using SHA1 for security reasons
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPassword = sb.toString();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                // Process the name
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}