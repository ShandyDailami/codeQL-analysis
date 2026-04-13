import java.sql.*;

public class java_02033_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM Users WHERE Password='" + args[0] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String passwordFromDB = rs.getString("Password");
                if (args[0].equals(passwordFromDB)) {
                    System.out.println("Access granted");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Access denied");
    }
}