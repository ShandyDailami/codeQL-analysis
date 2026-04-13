import java.sql.*;

public class java_36055_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/your_db";
    private static final String username = "username";
    private static final String password = "password";

    private Connection connection;

    public java_36055_JDBCQueryHandler_A01() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString("column_name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM your_table");
    }
}