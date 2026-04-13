import java.sql.*;

public class java_14907_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable")) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // handle the data...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}