import java.sql.*;

public class java_27800_JDBCQueryHandler_A07 {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Example of a SQL query
            String sql = "SELECT * FROM users WHERE username = '" + "user" + "' AND password = '" + "password" + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Handle the result set here
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