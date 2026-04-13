import java.sql.*;

public class java_19897_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";
        
        try {
            // Step 1: Establish a connection to the database
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Step 2: Create a statement object
            Statement stmt = con.createStatement();
            
            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Step 4: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
            
            // Step 5: Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}