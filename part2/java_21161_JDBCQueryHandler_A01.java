import java.sql.*;

public class java_21161_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // 1. Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. Create a Statement
            Statement stmt = con.createStatement();

            // 4. Execute a Query
            String sql = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Handle the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("Name: " + name);
                System.out.println("Password: " + password);
            }

            // 6. Close the Connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}