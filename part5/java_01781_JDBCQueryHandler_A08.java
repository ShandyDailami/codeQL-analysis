import java.sql.*;

public class java_01781_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE age = " + 18;
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Age: " + age);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}