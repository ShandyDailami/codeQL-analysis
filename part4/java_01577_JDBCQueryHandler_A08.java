import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01577_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_01577_JDBCQueryHandler_A08(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String updateQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(updateQuery);
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

// Example of a security-sensitive operation related to integrity failure
public class SecurityOperation {
    private static final String DB_URL = "jdbc:your_db_url";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(DB_URL, USER, PASSWORD);

            // Example of a query related to integrity failure
            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // This line can throw a SQLException if the resultSet is empty
                System.out.println(resultSet.getString("your_column"));
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
        }
    }
}