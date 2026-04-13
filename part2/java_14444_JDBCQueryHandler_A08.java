import java.sql.*;

public class java_14444_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_14444_JDBCQueryHandler_A08(String dbUrl, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        ResultSet rs = jdbcQueryHandler.executeQuery("SELECT * FROM your_table");

        while (rs.next()) {
            System.out.println(rs.getString("your_column_name"));
        }

        jdbcQueryHandler.executeUpdate("DELETE FROM your_table WHERE condition");
    }
}