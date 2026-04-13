import java.sql.*;

public class java_23665_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Valid credentials");
            } else {
                System.out.println("Invalid credentials");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        }
    }
}