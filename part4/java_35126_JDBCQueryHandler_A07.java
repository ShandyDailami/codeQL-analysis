import java.sql.*;

public class java_35126_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM your_table";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // TODO: Handle the data securely, e.g., prevent SQL injection
                String username = rs.getString("username");
                String password = rs.getString("password");

                // TODO: Implement authentication here using a secure way
                if (username.equals("admin") && password.equals("password")) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}