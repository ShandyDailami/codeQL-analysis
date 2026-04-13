import java.sql.*;

public class java_01209_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void handleQuery(String query) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // We are using a PreparedStatement here to prevent SQL Injection
            PreparedStatement pstmt = con.prepareStatement(query);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Assuming we have columns with names 'id' and 'name'
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBCQueryHandler: " + ex.getMessage());
        }
    }
}