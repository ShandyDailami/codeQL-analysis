import java.sql.*;

public class java_37229_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_37229_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        stmt.close();
        conn.close();
    }

    // example usage
    public static void main(String[] args) {
        try {
            // replace with your actual URL, username, and password
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM my_table");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}