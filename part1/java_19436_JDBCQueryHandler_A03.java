import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_19436_JDBCQueryHandler_A03 {

    // Dependency Injection
    private final Connection connection;

    public java_19436_JDBCQueryHandler_A03(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery(String query, Object[] params) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}