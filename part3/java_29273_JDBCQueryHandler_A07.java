import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29273_JDBCQueryHandler_A07 {

    private Connection connection;
    private Statement statement;

    public java_29273_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        this.statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }

    public void close() throws SQLException {
        if (this.statement != null) {
            this.statement.close();
        }
        if (this.connection != null) {
            this.connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet result = handler.executeQuery("SELECT * FROM users");

            while (result.next()) {
                System.out.println(result.getString("username"));
            }

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}