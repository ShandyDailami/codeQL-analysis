import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27223_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Create a Statement object
            Statement stmt = conn.createStatement();

            // Step 4: Perform a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Step 6: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}