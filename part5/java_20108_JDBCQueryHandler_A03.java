import java.sql.*;

public class java_20108_JDBCQueryHandler_A03 {

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
            String query = "SELECT * FROM my_table";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // d.
            ResultSet rs = pstmt.executeQuery();

            // e.
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // f.
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}