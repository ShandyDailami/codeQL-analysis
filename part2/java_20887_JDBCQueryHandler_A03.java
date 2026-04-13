import java.sql.*;

public class java_20887_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;

    public java_20887_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
        statement = connection.createStatement();
    }

    public void executeQuery(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}