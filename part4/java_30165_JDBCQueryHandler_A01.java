import java.sql.*;

public class java_30165_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_30165_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
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
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root").executeUpdate("CREATE TABLE Account (id INT PRIMARY KEY, name VARCHAR(100), balance DECIMAL(10, 2))");
            ResultSet resultSet = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root").executeQuery("SELECT * FROM Account");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + ", " + resultSet.getString("name") + ", " + resultSet.getString("balance"));
            }
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root").executeUpdate("DROP TABLE Account");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}