import java.sql.*;

public class java_05501_JDBCQueryHandler_A01 {

    private static final String JDBC_URL = "jdbc:sqlite:test.db"; // SQLite database file

    public static void main(String[] args) {

        // Initialize SQLite database
        initializeDatabase();

        // Perform operations
        performOperations();
    }

    private static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            // Create table
            String sql = "CREATE TABLE IF NOT EXISTS test (name text, age integer)";
            conn.createSchema("main"); // Create a new schema
            conn.setSchema("main"); // Set the schema
            conn.createTable(TableResult.class.getName(),
                    new TableColumn("name", DB_String.class.getName()),
                    new TableColumn("age", DB_Integer.class.getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performOperations() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, "", "")) { // empty password
            // Insert data
            String sql = "INSERT INTO main.test VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 20);
            pstmt.execute();

            // Select data
            sql = "SELECT * FROM main.test";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}