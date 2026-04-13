import java.sql.*;

public class java_28802_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to MySQL Server
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a Query
            String sql = "SELECT * FROM mytable";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");
                System.out.println(name + " - " + age + " - " + city);
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}