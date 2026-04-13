import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27116_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    public java_27116_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            // Replace with your own credentials
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // Access your data here
            }

            handler.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query: " + e.getMessage());
        }
    }
}