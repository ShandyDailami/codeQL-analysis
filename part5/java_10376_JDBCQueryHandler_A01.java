import java.sql.*;

public class java_10376_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

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