import java.sql.*;

public class java_29531_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM your_table"; // replace your SQL query here
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("column_name")); // replace "column_name" and "your_table" with your actual column name and table name
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}