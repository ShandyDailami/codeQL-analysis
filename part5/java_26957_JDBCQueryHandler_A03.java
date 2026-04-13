import java.sql.*;

public class java_26957_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Example of a SQL injection attack
            // The following query will be executed as if we were inserting the string '1' into the 'id' column
            // This is a simple example of an SQL injection attack
            String sql = "SELECT * FROM users WHERE id = " + '1';
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
         e.printStackTrace();
        }
    }
}