import java.sql.*;
import java.util.Properties;

public class java_39188_JDBCQueryHandler_A03 {
    private static ConnectionPoolDataSource dataSource;

    public static void main(String[] args) {
        dataSource = new ConnectionPoolDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setURL("jdbc:mysql://localhost:3306/mydatabase");

        String query = "SELECT * FROM users WHERE username = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "user1"); // User is not safe here, but this is just to illustrate injection.
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println("User: " + username);
            }

            dataSource.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}