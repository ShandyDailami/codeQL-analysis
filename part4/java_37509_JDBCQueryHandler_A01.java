import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37509_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_37509_JDBCQueryHandler_A01(String dbUrl, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, username, password);
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
}

public class BrokenAccessControlExample {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler queryHandler = new JDBCQueryHandler(dbUrl, username, password);

            String query = "SELECT * FROM users WHERE role='ADMIN'";
            ResultSet resultSet = queryHandler.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("User name: " + name);
            }

            queryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}