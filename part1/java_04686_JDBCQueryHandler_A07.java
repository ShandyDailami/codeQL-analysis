import java.sql.*;

public class java_04686_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Get a connection to the database
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement stmt = con.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

            // Step 4: Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}