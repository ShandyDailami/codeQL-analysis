import java.sql.*;
import java.util.Properties;

public class java_01933_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("user", "dbuser");
        props.setProperty("password", "dbpassword");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", props);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}