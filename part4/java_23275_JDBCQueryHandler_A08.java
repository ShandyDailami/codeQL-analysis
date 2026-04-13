import java.sql.*;

public class java_23275_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                // process the data...
            }

            // Step 5: Close the ResultSet and the statement
            rs.close();
            stmt.close();

            // Step 6: Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}