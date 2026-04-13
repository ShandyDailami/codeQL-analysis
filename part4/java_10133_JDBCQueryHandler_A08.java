import java.sql.*;

public class java_10133_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Example of a SELECT query
            String sql = "SELECT * FROM mytable WHERE myfield = 'myvalue'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("myfield"));
            }

            // Example of a DELETE query
            sql = "DELETE FROM mytable WHERE myfield = 'myvalue'";
            stmt.executeUpdate(sql);

            // Example of an INSERT query
            sql = "INSERT INTO mytable (myfield) VALUES ('myvalue')";
            stmt.executeUpdate(sql);

            // Example of an UPDATE query
            sql = "UPDATE mytable SET myfield = 'newvalue' WHERE myfield = 'myvalue'";
            stmt.executeUpdate(sql);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}