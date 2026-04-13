import java.sql.*;

public class java_14883_JDBCQueryHandler_A01 {

    // Assume we have a DB connection
    private Connection conn;

    public java_14883_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Assume we are working with a simple table
                System.out.println(rs.getString("column_name"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with your actual values
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM table_name");
    }
}