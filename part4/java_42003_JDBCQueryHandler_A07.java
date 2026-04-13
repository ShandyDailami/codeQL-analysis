import java.sql.*;

public class java_42003_JDBCQueryHandler_A07 {

    public static final String URL = "jdbc:mysql://localhost:3306/db_name";
    public static final String USER = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Define a SQL query
            String query = "SELECT * FROM your_table";

            // Step 3: Prepare the statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute the query and get the result set
            ResultSet rs = stmt.executeQuery(query);

            // Step 5: Process the result set
            while (rs.next()) {
                // Assuming the table has columns 'id', 'name', and 'email'
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 6: Close the result set and statement
            rs.close();
            stmt.close();

            // Step 7: Close the connection
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
    }
}