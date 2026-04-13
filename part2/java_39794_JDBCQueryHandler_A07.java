import java.sql.*;
import java.util.Properties;

public class java_39794_JDBCQueryHandler_A07 {

    private Connection conn;
    private Statement stmt;

    public java_39794_JDBCQueryHandler_A07() {
        createConnection();
        createStatement();
    }

    private void createConnection() {
        Properties props = new Properties();
        props.setProperty("user", "username");
        props.setProperty("password", "password");
        props.setProperty("database", "database");
        props.setProperty("server", "server");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://server:3306/database", props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}