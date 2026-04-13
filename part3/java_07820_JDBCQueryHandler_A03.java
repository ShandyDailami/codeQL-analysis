import java.sql.*;

public class java_07820_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Start a new transaction
        String sql = "BEGIN TRANSACTION;";
        try (Statement stmt = conn.createStatement()) {
            // Execute SQL statement
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insert a new user
        String sql2 = "INSERT INTO users (name, email) VALUES ('test', 'test@gmail.com');";
        try (Statement stmt2 = conn.createStatement()) {
            stmt2.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Select the user
        String sql3 = "SELECT * FROM users WHERE name = 'test';";
        try (Statement stmt3 = conn.createStatement()) {
            ResultSet rs = stmt3.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Commit the transaction
        String sql4 = "COMMIT;";
        try (Statement stmt4 = conn.createStatement()) {
            stmt4.execute(sql4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}