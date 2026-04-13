import java.sql.*;

public class java_22667_JDBCQueryHandler_A03 {

    private Connection connection;
    private Statement statement;

    public java_22667_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}