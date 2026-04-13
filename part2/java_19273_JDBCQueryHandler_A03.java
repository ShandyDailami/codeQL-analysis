import java.sql.*;

public class java_19273_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 123); // replace 123 with your ID

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}