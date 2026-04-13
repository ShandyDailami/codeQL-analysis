import java.sql.*;

public class java_35671_JDBCQueryHandler_A01 {
    // URL and credentials for the database
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection from the DriverManager
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees WHERE Department='Sales'");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("Name");
                int salary = rs.getInt("Salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Step 5: Close the ResultSet and the connection
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}