import java.sql.*;

public class java_39419_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_39419_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = rs.getString("column_name"); // Replace "column_name" with the actual name of the column you want to retrieve
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Replace the placeholders with actual values
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        String result = handler.executeQuery("SELECT * FROM my_table");
        System.out.println("Result: " + result);
    }
}