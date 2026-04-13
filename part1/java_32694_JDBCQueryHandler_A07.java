import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32694_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_32694_JDBCQueryHandler_A07(Connection connection) {
        this.connection = connection;
    }

    public void handleQuery(String query, Object[] params) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}