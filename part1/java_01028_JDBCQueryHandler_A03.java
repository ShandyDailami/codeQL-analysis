import java.sql.*;

public class java_01028_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // MySQL database credentials
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection(url, username, password);

            // Execute a query
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the results
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}