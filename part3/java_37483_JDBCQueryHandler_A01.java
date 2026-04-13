import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37483_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_37483_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void executeQuery(String query) {
        try {
            if (connection != null && connection.isClosed()) {
                connection = DriverManager.getConnection(connection.getMetaData().getURL(), connection.getMetaData().getUserName(), connection.getMetaData().getPassword());
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column1") + " - " + resultSet.getString("column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            handler.executeQuery("SELECT * FROM test_table");
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}