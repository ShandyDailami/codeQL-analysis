import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08501_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_08501_JDBCQueryHandler_A03(String dbURL, String user, String password) {
        try {
            // DriverManager loads the database driver.
            // This step is required if your application is using any database.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates a connection to the database.
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void executeUpdate(String query) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
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
}