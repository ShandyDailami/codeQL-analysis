import org.simpleframework.jdbc.core.Engine;
import org.simpleframework.jdbc.core.JdbcCore;
import org.simpleframework.jdbc.core.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10355_JDBCQueryHandler_A01 {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Engine engine;

    public java_10355_JDBCQueryHandler_A01() {
        try {
            Class.forName(DATABASE_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            engine = new JdbcCore(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, Object[] params, ResultHandler handler) {
        try (Connection connection = engine.getConnection();
             Statement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            handler.handle(statement.executeStatement());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface ResultHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}