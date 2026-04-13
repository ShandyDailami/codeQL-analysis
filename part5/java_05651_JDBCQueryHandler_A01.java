import java.sql.*;

public class java_05651_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_05651_JDBCQueryHandler_A01(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:your_database_url", "username", "password").executeUpdate("CREATE TABLE test (id INT PRIMARY KEY, name VARCHAR(255));");
            new JDBCQueryHandler("jdbc:your_database_url", "username", "password").executeUpdate("INSERT INTO test (id, name) VALUES (1, 'John');");
            ResultSet resultSet = new JDBCQueryHandler("jdbc:your_database_url", "username", "password").executeQuery("SELECT * FROM test;");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
            new JDBCQueryHandler("jdbc:your_database_url", "username", "password").closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}