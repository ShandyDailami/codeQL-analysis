import java.sql.*;

public class java_15543_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_15543_JDBCQueryHandler_A03(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String updateQuery) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(updateQuery);
            stmt.close();
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

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");

        try {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        handler.executeUpdate("INSERT INTO Users (name) VALUES ('John')");
    }
}