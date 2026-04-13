import java.sql.*;

public class java_02615_JDBCQueryHandler_A07 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Execute the Query
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}