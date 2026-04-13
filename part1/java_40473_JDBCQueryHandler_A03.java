import java.sql.*;

public class java_40473_JDBCQueryHandler_A03 {

    public static Connection getConnection() throws SQLException {
        // You would typically want to get these values from some sort of configuration file or some other source
        String url = "jdbc:your_db_url";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM your_table";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("your_column_name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBC connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}