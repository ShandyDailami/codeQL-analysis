import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_31760_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_31760_JDBCQueryHandler_A08() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> executeQuery(String query, RowMapper<T> rowMapper) {
        List<T> results = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                results.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("CREATE TABLE test (id INT PRIMARY KEY, name VARCHAR(255))");
        handler.executeQuery("INSERT INTO test (id, name) VALUES (1, 'Test')");

        List<Test> tests = handler.executeQuery("SELECT * FROM test", rs -> {
            return new Test(rs.getInt("id"), rs.getString("name"));
        });

        for (Test test : tests) {
            System.out.println(test);
        }

        handler.executeQuery("DROP TABLE test");
    }

    private static class Test {
        private int id;
        private String name;

        public java_31760_JDBCQueryHandler_A08(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "Test{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
}