import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class java_06821_JDBCQueryHandler_A03 {
    private static Connection connection;
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(JDBCQueryHandler.class.getResourceAsStream("/config.properties"));
            Class.forName(properties.getProperty("database.driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("database.url"),
                    properties.getProperty("database.username"),
                    properties.getProperty("database.password"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Cannot initialize database connection");
        }
    }

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeQuery();
    }
}