import java.sql.*;

public class java_36462_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute SQL query
            String sql = "SELECT * FROM Users INNER JOIN Orders ON Users.id = Orders.user_id INNER JOIN Products ON Orders.product_id = Products.id";
            ResultSet rs = stmt.executeQuery(sql);

            // Process result set
            while (rs.next()) {
                String userName = rs.getString("Users.name");
                String productName = rs.getString("Products.name");
                int quantity = rs.getInt("Products.quantity");
                System.out.println("User: " + userName + ", Product: " + productName + ", Quantity: " + quantity);
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}