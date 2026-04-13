import java.sql.*;

public class java_25102_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = con.createStatement();

            // Step 3: Execute a SQL Query
            String sql = "INSERT INTO employees(id, name, salary) VALUES(1, 'John Doe', 50000)";
            stmt.executeUpdate(sql);

            System.out.println("Data inserted successfully!");

            // Step 4: Close the Connection
            con.close();

        } catch (SQLException e) {
            System.out.println("Error in connection: " + e);
       
        }
    }
}