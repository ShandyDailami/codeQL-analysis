import java.sql.*;

public class java_33933_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_33933_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, QueryCallback callback) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            callback.onResult(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface QueryCallback {
        void onResult(ResultSet result);
    }
}

public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();

        jdbcHandler.executeQuery("SELECT * FROM your_table", result -> {
            while (result.next()) {
                System.out.println(result.getString("your_column"));
            }
        });
    }
}