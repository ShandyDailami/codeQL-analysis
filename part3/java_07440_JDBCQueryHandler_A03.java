import java.sql.*;

public class java_07440_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_07440_JDBCQueryHandler_A03() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, ResultHandler resultHandler) {
        try {
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY);
            statement.setFetchSize(Integer.MIN_VALUE);
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                resultHandler.handle(resultSet);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface ResultHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        ResultHandler resultHandler = new ResultHandler() {
            @Override
            public void handle(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }
        };

        String query = "SELECT id, name FROM users";

        jdbcQueryHandler.executeQuery(query, resultHandler);
    }
}