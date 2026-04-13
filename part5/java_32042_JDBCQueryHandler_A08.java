import java.sql.*;

public class java_32042_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_32042_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = null;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                result = rs.getString("column_name");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        // Replace "url", "username", and "password" with your actual database credentials.
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        String result = handler.executeQuery("SELECT * FROM table");
        System.out.println("Result: " + result);
    }
}