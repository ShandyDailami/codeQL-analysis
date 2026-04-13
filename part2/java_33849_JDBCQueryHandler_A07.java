import java.sql.*;
import java.util.Properties;

public class java_33849_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","root");
        try {
            Connection conn = DriverManager.getConnection(url, props);

            String sql = "SELECT * FROM Employee WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123); // assuming you want to get employee with id 123
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}