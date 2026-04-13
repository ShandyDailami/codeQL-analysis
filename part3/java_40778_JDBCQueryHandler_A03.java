import java.sql.*;

public class java_40778_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_40778_JDBCQueryHandler_A03(String dbUrl, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // For example, to execute a query
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");

        // You could then process the ResultSet here, e.g. to print all user names
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        // For example, to execute an update query
        int rowsAffected = jdbcQueryHandler.executeUpdate("UPDATE users SET email='newemail@example.com' WHERE id=1");
        System.out.println("Rows affected: " + rowsAffected);
    }
}