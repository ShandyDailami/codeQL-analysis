import java.sql.*;

public class java_36724_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // The URL, username, and password for the database connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepare the SQL query
            String sql = "SELECT * FROM Employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Process the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        }
    }
}