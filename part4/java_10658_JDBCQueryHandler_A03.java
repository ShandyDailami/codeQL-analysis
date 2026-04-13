import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_10658_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_10658_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query, Object[] params) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String selectQuery = "SELECT * FROM users WHERE id = ?";
        Object[] selectParams = {123};
        handler.executeQuery(selectQuery, selectParams);

        String insertQuery = "INSERT INTO users (id, name) VALUES (?, ?)";
        Object[] insertParams = {456, "User Name"};
        handler.executeQuery(insertQuery, insertParams);

        connection.close();
    }
}