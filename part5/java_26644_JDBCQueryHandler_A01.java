import java.sql.*;

public class java_26644_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM mytable";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query");
            e.printStackTrace();
        }
    }
}