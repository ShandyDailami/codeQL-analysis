import java.sql.*;

public class java_13365_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + 1)) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error in accessing DB");
            e.printStackTrace();
        }
    }
}