import java.sql.*;

public class java_29558_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the results
            while (rs.next()) {
                String column1 = rs.getString("column1");
                String column2 = rs.getString("column2");
                // ... do something with the column values ...
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
    }
}