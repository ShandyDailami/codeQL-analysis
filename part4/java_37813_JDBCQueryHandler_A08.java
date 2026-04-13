import java.sql.*;

public class java_37813_JDBCQueryHandler_A08 {

    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // Example of a SELECT statement
            String sql = "SELECT * FROM Employee WHERE Salary > ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, 50000);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println(id + ", " + name + ", " + salary);
            }

            // Example of a INSERT statement
            sql = "INSERT INTO Employee (id, name, salary) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 6);
            pstmt.setString(2, "John");
            pstmt.setDouble(3, 60000);
            pstmt.executeUpdate();

            // Example of a DELETE statement
            sql = "DELETE FROM Employee WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 6);
            pstmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}