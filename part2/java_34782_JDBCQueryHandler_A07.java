import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_34782_JDBCQueryHandler_A07 {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASS = "password";

    private Connection connection;

    public java_34782_JDBCQueryHandler_A07() {
        initializeDatabaseConnection();
    }

    private void initializeDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, ResultSetHandler resultSetHandler) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            resultSetHandler.handle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private interface ResultSetHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}