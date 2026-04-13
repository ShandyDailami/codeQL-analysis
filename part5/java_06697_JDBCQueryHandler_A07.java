import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06697_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;
    private Statement statement;

    public void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        try {
            jdbcQueryHandler.openConnection();
            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM your_table_name");
            while (resultSet.next()) {
                // process the result set
            }
            jdbcQueryHandler.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}