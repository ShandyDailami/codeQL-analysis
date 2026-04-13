import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_21702_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_21702_JDBCQueryHandler_A03(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void executeUpdate(String query) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "root", "password");
        List<String> result = handler.executeQuery("SELECT * FROM users");
        for (String s : result) {
            System.out.println(s);
        }
        handler.executeUpdate("INSERT INTO users (name) VALUES ('test')");
    }
}