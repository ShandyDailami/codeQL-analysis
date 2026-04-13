import java.sql.*;

public class java_24455_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_24455_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query, Object[] params, Callback callback) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            ResultSet resultSet = pstmt.executeQuery();
            callback.handleResultSet(resultSet);
        } catch (SQLException e) {
            callback.handleError(e.getMessage());
        }
    }

    public interface Callback {
        void handleResultSet(ResultSet resultSet);

        void handleError(String errorMessage);
    }
}