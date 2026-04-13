import java.sql.*;

public class java_33106_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Example of a SELECT query. Replace with your actual query.
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 123); // replace with actual user id

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                // process the result set...
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}