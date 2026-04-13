import java.sql.*;

public class java_17049_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_17049_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password").executeUpdate("CREATE TABLE test (id INT, name VARCHAR(255))");
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password").executeUpdate("INSERT INTO test (id, name) VALUES (1, 'John')");
            ResultSet resultSet = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password").executeQuery("SELECT * FROM test");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password").closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}