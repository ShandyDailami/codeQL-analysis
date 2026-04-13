import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23973_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    public java_23973_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            // load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish the connection
            this.connection = DriverManager.getConnection(url, username, password);
            this.statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runQuery(String query) {
        ResultSet resultSet = null;
        try {
            // execute the query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet resultSet = handler.runQuery("SELECT * FROM users");
        // process the result set here
        handler.closeConnection();
    }
}