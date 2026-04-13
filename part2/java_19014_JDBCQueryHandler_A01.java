import java.sql.*;

public class java_19014_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE salary > 50000");

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error in SQL query execution: " + e.getMessage());
        }
    }
}