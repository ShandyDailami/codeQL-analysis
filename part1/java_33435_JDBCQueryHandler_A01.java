import java.sql.*;

public class java_33435_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open Connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create Statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL
            String sql = "SELECT * FROM employees WHERE salary > ? AND department = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, 5000);
            pstmt.setString(2, "Sales");

            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process Result Set
            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String department = rs.getString("department");
                System.out.println(name + ", " + salary + ", " + department);
            }

            // Step 6: Close Statement and Connection
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}