import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22554_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final int ERROR_CODE = 1000;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (Statement statement = connection.createStatement()) {
                int result = executeQuery(statement, "SELECT 1 FROM DUAL WHERE 1=0");
                if (result == ERROR_CODE) {
                    System.out.println("Authentication failure occurred");
                } else {
                    System.out.println("Authentication successful");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int executeQuery(Statement statement, String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return ERROR_CODE;
        } else {
            return resultSet.getInt(1);
        }
    }
}