import java.sql.*;

public class java_36148_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_36148_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

            ResultSet rs = handler.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}