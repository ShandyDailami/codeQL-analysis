import java.sql.*;

public class java_19557_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // a.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // b.
            Connection conn = DriverManager.getConnection(url, user, password);

            // c.
            Statement stmt = conn.createStatement();

            // d.
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // e.
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("User Name: " + rs.getString("name"));
            }

            // f.
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}