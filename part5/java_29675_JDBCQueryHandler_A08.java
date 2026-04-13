import java.sql.*;
import java.util.Properties;

public class java_29675_JDBCQueryHandler_A08 {
    private Properties props;

    public java_29675_JDBCQueryHandler_A08(Properties props) {
        this.props = props;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        connection.close();

        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

        connection.close();
    }
}