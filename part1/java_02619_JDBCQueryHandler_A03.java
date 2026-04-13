import java.sql.*;

public class java_02619_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");
                //... process the data
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}