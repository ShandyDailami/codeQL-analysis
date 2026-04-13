import java.sql.*;

public class java_06628_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_06628_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void executeUpdate(String update, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(update);
        statement.executeUpdate();
        connection.close();
    }

    public ResultSet executeQuery(String query, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }
}

public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");

        try {
            Connection connection = handler.getConnection();
            handler.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(100), age INT)", connection);
            handler.executeUpdate("INSERT INTO users (id, name, age) VALUES (1, 'John', 25)", connection);

            ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE age > 20", connection);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
            }

            handler.executeUpdate("DROP TABLE users", connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}