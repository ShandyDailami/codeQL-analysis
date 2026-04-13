import java.sql.*;

public class java_20735_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM my_table";
            Statement stmt = conn.createStatement();

            // Step 4: Execute the statement
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("Name: " + name);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}