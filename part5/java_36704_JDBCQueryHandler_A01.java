import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36704_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_36704_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void performReadOperation(Connection conn) throws SQLException {
        // Here is where the read operation would go, for example:
        // Statement stmt = conn.createStatement();
        // ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        // while (rs.next()) {
        //     String name = rs.getString("name");
        //     int age = rs.getInt("age");
        //     System.out.println(name + ", " + age);
        // }
    }

    public void performWriteOperation(Connection conn) throws SQLException {
        // Here is where the write operation would go, for example:
        // Statement stmt = conn.createStatement();
        // stmt.executeUpdate("INSERT INTO employees (name, age) VALUES ('John', 30)");
    }
}