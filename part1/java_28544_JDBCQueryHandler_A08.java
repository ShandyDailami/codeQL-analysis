import java.sql.*;

public class java_28544_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_28544_JDBCQueryHandler_A08() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;

        try {
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "INSERT INTO employees (id, name, salary) VALUES (1, 'John', 10000)";
        handler.executeUpdate(query);

        query = "UPDATE employees SET salary = 20000 WHERE id = 1";
        handler.executeUpdate(query);

        query = "DELETE FROM employees WHERE id = 1";
        handler.executeUpdate(query);
    }
}