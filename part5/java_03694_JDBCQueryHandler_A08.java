import java.sql.*;
import java.util.Properties;

public class java_03694_JDBCQueryHandler_A08 {
    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.setProperty("user","dbuser");
            props.setProperty("password","dbpassword");
            props.setProperty("useSSL","false");
            props.setProperty("serverTimezone","IST");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","dbuser","dbpassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, email) VALUES(?, ?)");
            stmt.setString(1, "testUser");
            stmt.setString(2, "testUser@example.com");
            stmt.executeUpdate();

            stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
            stmt.setString(1, "testUser");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }

            rs.close();
            stmt.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}