import java.sql.*;
import java.util.Properties;

public class java_10087_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            Connection con = DriverManager.getConnection(url, props);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM mytable"; // replace with your SQL query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("mycolumn")); // replace with your column name
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}