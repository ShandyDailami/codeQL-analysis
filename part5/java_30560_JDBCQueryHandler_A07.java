import java.sql.*;

public class java_30560_JDBCQueryHandler_A07 {

    // This is just a placeholder for your database credentials.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement object.
            Statement stmt = conn.createStatement();

            // Step 3: Execute a query.
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 4: Process the ResultSet.
            while (rs.next()) {
                // You can get the data from the ResultSet using rs.getXXX() methods.
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection.
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}