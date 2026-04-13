import java.sql.*;

public class java_39406_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Open connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to the database!");

            // Read data
            String selectQuery = "SELECT column_name FROM table_name";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(selectQuery);

                while (rs.next()) {
                    System.out.println(rs.getString("column_name"));
                }
            }

            // Insert data
            String insertQuery = "INSERT INTO table_name (column_name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, "new data");
                pstmt.executeUpdate();
            }

            // Update data
            String updateQuery = "UPDATE table_name SET column_name = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setString(1, "updated data");
                pstmt.setInt(2, 1);
                pstmt.executeUpdate();
            }

            // Delete data
            String deleteQuery = "DELETE FROM table_name WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, 1);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: " + ex.getMessage());
        }
    }
}