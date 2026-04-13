import java.sql.*;

public class java_26486_JDBCQueryHandler_A01 {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private final String url = "jdbc:mysql://localhost:3306/testdb";
    private final String username = "root";
    private final String password = "password";

    public java_26486_JDBCQueryHandler_A01() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateQuery(String query) {
        try {
            stmt.executeUpdate(query);
            System.out.println("Update successful!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.selectQuery("SELECT * FROM Users");
        jdbcQueryHandler.updateQuery("UPDATE Users SET name='John' WHERE id=1");
        jdbcQueryHandler.closeConnection();
    }
}