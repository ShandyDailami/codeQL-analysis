import java.sql.*;

public class java_08494_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            Statement stmt = con.createStatement();

            // Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees WHERE salary > 50000");

            // Extract data from result set
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Close connections
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error in SQL Query: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found: " + e.getMessage());
        }
    }
}