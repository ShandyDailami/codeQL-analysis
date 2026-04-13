import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;

public class java_11569_JDBCQueryHandler_A08 {

    private final Supplier<Connection> connectionSupplier;

    public java_11569_JDBCQueryHandler_A08(String url, String username, String password) {
        connectionSupplier = () -> DriverManager.getConnection(url, username, password);
    }

    public <T> T withConnection(ConnectionConsumer<T> consumer) throws SQLException {
        try (Connection connection = connectionSupplier.get()) {
            return consumer.accept(connection);
        }
    }

    public interface ConnectionConsumer<T> {
        T accept(Connection connection) throws SQLException;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        handler.withConnection(connection -> {
            // Perform operations on the connection
            // For example, fetch data
            return connection.createStatement().executeQuery("SELECT * FROM Users");
        });
    }
}