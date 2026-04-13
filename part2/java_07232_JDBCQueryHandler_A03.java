import java.sql.*;

public class java_07232_JDBCQueryHandler_A03 {
    // Define the database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            Statement stmt = con.createStatement();

            // Step 4: Execute a SQL Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
                // Add more columns as needed
            }

            // Step 6: Close the ResultSet and the Statement
            rs.close();
            stmt.close();

            // Step 7: Close the Connection
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}