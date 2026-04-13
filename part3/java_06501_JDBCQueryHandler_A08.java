import java.sql.*;

public class java_06501_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            String sql = "SELECT * FROM users";
            Statement stmt = con.createStatement();

            // Execute the statement and get a result set
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
        }
    }
}