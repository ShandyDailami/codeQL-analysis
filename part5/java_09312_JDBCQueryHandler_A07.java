import java.sql.*;

public class java_09312_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE id = ?";
            ResultSet rs = stmt.executeQuery(sql, 1);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}