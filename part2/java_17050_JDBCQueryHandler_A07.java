import java.sql.*;

public class java_17050_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM my_table WHERE condition";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Handle the result set here
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}