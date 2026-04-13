import java.sql.*;
import java.util.Properties;

public class java_35118_JDBCQueryHandler_A03 {

    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Or com.mysql.jdbc.Driver, based on your database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM my_table"; // Your query
        ResultSet rs = executeQuery(query);

        try {
            if (rs != null) {
                while (rs.next()) {
                    System.out.println(rs.getString("column_name")); // Use your actual column names
                }
                rs.close();
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}