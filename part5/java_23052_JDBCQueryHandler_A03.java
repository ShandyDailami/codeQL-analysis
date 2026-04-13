import java.sql.*;

public class java_23052_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 2: Prepare a Statement
            String sql = "SELECT * FROM myTable";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the Statement and Fetch the Result
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the Result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // ... perform other operations on name and age
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}