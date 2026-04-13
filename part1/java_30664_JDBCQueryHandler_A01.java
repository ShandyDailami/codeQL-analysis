import java.sql.*;

public class java_30664_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2: Prepare the query
            String sql = "SELECT * FROM myTable"; // replace with your query
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database or executing the query.");
            e.printStackTrace();
        }
    }
}