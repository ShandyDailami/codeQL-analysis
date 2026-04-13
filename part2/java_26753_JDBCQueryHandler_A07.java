import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class java_26753_JDBCQueryHandler_A07 {
    private Connection conn;

    public void connect(String url, String username, String password) {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try {
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            this.conn.createStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (this.conn != null && !this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
        handler.executeQuery("SELECT * FROM mytable");
        handler.closeConnection();
    }
}