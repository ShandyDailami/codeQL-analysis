import java.sql.*;

public class java_27795_JDBCQueryHandler_A03 {

    private Connection connection;
    private Statement statement;

    public java_27795_JDBCQueryHandler_A03(String dbUrl, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/dbname", "username", "password");
        jdbcQueryHandler.executeQuery("SELECT name FROM users");
        jdbcQueryHandler.executeUpdate("UPDATE users SET name = 'newName' WHERE id = 1");
    }
}