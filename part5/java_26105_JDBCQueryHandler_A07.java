import java.sql.*;

public class java_26105_JDBCQueryHandler_A07 {

    private Connection connection;
    private Statement statement;

    public java_26105_JDBCQueryHandler_A07(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // replace with your actual database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password");

        ResultSet result = handler.executeQuery("SELECT * FROM your_table");
        while (result.next()) {
            // handle the result set here
        }

        handler.closeConnection();
    }
}