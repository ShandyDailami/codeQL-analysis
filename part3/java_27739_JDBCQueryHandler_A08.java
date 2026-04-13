import java.sql.*;

public class java_27739_JDBCQueryHandler_A08 {
    // database credentials
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";
    // database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // method to execute a query
    public static void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    // method to update data
    public static void updateData(String updateQuery) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        }
    }

    // main method to test the functionality
    public static void main(String[] args) {
        // example query
        String selectQuery = "SELECT * FROM table_name";
        // example update query
        String updateQuery = "UPDATE table_name SET column_name = 'new_value' WHERE condition";
        executeQuery(selectQuery);
        updateData(updateQuery);
    }
}