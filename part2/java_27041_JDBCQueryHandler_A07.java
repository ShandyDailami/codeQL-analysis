import java.sql.*;
import java.util.Properties;

public class java_27041_JDBCQueryHandler_A07 {
    public static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.setProperty("user", "username");
            props.setProperty("password", "password");
            props.setProperty("characterEncoding", "utf8");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println(username + ", " + password);
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}