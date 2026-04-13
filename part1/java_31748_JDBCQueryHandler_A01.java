import java.sql.*;

public class java_31748_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Create a statement
            Statement stmt = con.createStatement();

            // Step 4: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE password = 'secret'");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}