import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11087_JDBCQueryHandler_A01 {

    private Connection connection;

    // Load driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public java_11087_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            if (connection != null && !connection.isClosed()) {
                java.sql.Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
                stmt.closeOnCompletion();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);
        queryHandler.executeQuery("SELECT * FROM my_table");
    }
}