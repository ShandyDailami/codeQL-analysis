import java.sql.*;

public class java_25444_JDBCQueryHandler_A03 {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    // Establish a connection
    public Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Close the connection
    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a query
    public void executeQuery(String query, String param) {
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, param);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        handler.establishConnection();

        String query = "SELECT id, name FROM table WHERE id = ?";
        String param = "1";

        handler.executeQuery(query, param);

        handler.closeConnection();
    }
}