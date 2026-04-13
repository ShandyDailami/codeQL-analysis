import java.sql.*;

public class java_11036_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM your_table WHERE authentication_failure = 1";
            Statement stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 5: Process the result
            while (rs.next()) {
                // You can access the data in rs using rs.getString("column_name")
                // or rs.getInt("column_name") etc.
                System.out.println("Authentication failure found in table!");
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }
}