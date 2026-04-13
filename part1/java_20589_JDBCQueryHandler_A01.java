import java.sql.*;

public class java_20589_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM SensitiveData WHERE id=? AND password=?");
    }

    private static void executeQuery(String query) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // Input validation
            validateInputs(statement);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    private static void validateInputs(PreparedStatement statement) throws SQLException {
        for (int i = 0; i < statement.getParameterMetaData().getParameterCount(); i++) {
            boolean isInput = statement.getParameterMetaData().getParameterType(i).isInput();
            if (!isInput) {
                throw new SQLException("Invalid input in query parameter at position " + i);
            }
        }
    }
}