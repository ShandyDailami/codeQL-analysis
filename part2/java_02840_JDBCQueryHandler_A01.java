import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_02840_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public void connect(String dbURL) {
        try {
            connection = DriverManager.getConnection(dbURL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:sqlite:test.db");
        ResultSet resultSet = handler.executeQuery("SELECT * FROM myTable");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        handler.disconnect();
    }
}