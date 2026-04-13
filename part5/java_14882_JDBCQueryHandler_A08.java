import java.sql.*;

public class java_14882_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM A08_IntegrityFailure";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("fieldName"));
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}