import java.sql.*;

public class java_20713_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_20713_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}