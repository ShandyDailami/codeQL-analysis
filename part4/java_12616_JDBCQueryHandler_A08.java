import java.sql.*;

public class java_12616_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable WHERE mycondition");

            // Step 4: Process the result set
            while (rs.next()) {
                // You can access the data by calling rs.getString(columnIndex)
                String data = rs.getString(1);
                System.out.println(data);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}