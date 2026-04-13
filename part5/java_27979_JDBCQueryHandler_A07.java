import java.sql.*;

public class java_27979_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_27979_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            this.conn = DriverManager.getConnection(dbURL, user, password);
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
        }
        return null;
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
        // Execute a query
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "user", "password");
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM users");

        // Process the ResultSet
        try {
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}