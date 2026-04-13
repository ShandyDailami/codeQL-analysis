import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01612_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "testuser";
        String password = "testpassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Create a new table
            String createTableSQL = "CREATE TABLE Employee" +
                    "(id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "salary DOUBLE)";
            stmt.executeUpdate(createTableSQL);

            // Insert data into the table
            String insertSQL = "INSERT INTO Employee (id, name, salary) VALUES (1, 'John', 7000.0)";
            stmt.executeUpdate(insertSQL);

            // Query the table
            String selectSQL = "SELECT id, name, salary FROM Employee";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}