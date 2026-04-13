import java.sql.*;
import java.util.ArrayList;

public class java_26749_JDBCQueryHandler_A03 {
    private ArrayList<String> queries;
    private Connection connection;

    public java_26749_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.queries = new ArrayList<String>();
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void addQuery(String query) {
        this.queries.add(query);
    }

    public void executeQueries() throws SQLException {
        for (String query : this.queries) {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // Handle the result set here
            }
            resultSet.close();
            statement.close();
        }
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}