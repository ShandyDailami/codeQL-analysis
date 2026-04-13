import java.sql.*;

public class java_18541_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_example";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_18541_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler();

        String query = "SELECT * FROM Users WHERE id = ?";
        ResultSet rs = jdbc.executeQuery(query);

        try {
            if (rs != null) {
                while (rs.next()) {
                    System.out.println(rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc.closeConnection();
    }
}