import java.sql.*;

public class java_34190_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_34190_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // process each row
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM users");
    }
}