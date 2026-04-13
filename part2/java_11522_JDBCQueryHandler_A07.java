import java.sql.*;

public class java_11522_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_11522_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
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

    public void executeUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        jdbcQueryHandler.executeUpdate("INSERT INTO users (name) VALUES ('John')");
    }
}