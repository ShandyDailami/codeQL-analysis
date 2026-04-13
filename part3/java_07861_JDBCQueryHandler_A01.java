import java.sql.*;

public class java_07861_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_07861_JDBCQueryHandler_A01(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public <T> List<T> fetchData(String query, RowMapper<T> mapper, Object... parameters) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            preparedStatement.setObject(i, parameters[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        List<T> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(mapper.mapRow(resultSet));
        }
        return data;
    }

    public interface RowMapper<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }
}