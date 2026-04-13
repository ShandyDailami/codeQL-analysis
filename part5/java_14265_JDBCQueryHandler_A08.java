import java.sql.*;
import java.util.function.ResultSetConsumer;

public class java_14265_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_14265_JDBCQueryHandler_A08(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery(String query, ResultSetConsumer<ResultSet> consumer) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            consumer.accept(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}