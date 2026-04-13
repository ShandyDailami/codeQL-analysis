import java.sql.*;

public class java_37044_JDBCQueryHandler_A01 {
    private Connection conn = null;

    public void connect(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Disconnection Error: " + e.getMessage());
            }
        }
    }

    public ResultSet executeQuery(String query) {
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                return stmt.executeQuery(query);
            } catch (SQLException e) {
                System.out.println("Query Error: " + e.getMessage());
            }
        }
        return null;
    }

    public int executeUpdate(String query) {
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                return stmt.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("Update Error: " + e.getMessage());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");

        ResultSet result = handler.executeQuery("SELECT * FROM mytable");
        while (result.next()) {
            System.out.println(result.getString("myfield"));
        }

        handler.disconnect();
    }
}