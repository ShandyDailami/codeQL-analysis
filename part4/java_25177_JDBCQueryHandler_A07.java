import java.sql.*;

public class java_25177_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_25177_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM table");
        while (rs.next()) {
            System.out.println(rs.getString("columnName"));
        }
        handler.executeUpdate("UPDATE table SET columnName='newValue' WHERE columnName='oldValue'");
    }
}