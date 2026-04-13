import java.sql.*;

public class java_41726_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:your_db_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM your_table";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // perform your authentication logic here
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}