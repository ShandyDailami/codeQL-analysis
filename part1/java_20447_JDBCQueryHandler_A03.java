import java.sql.*;

public class java_20447_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String SQL = "SELECT * FROM your_table";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the statement
            ResultSet rs = stmt.executeQuery(SQL);

            // Step 4: Process the result set
            while (rs.next()) {
                // Assume that the table has columns named 'id' and 'name'
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
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