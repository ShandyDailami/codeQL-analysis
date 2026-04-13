import java.sql.*;

public class java_17246_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE name = ?";
        String name = "John";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("name");
                int userId = rs.getInt("id");
                System.out.println("User name: " + userName);
                System.out.println("User id: " + userId);
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBC operation.");
            ex.printStackTrace();
        }
    }
}