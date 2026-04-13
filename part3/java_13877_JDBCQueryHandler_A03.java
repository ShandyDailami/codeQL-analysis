import java.sql.*;

public class java_13877_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM mytable";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Found row: " + rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database or executing the query.");
            e.printStackTrace();
        }
    }
}