import java.sql.*;

public class java_35845_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/db_example";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Query the database
            ResultSet rs = stmt.executeQuery("SELECT * FROM table_example");

            while (rs.next()) {
                System.out.println(rs.getString("column_example"));
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}