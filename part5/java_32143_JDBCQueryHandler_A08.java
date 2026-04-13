import java.sql.*;

public class java_32143_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM A08_IntegrityFailure";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Handle the result
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}