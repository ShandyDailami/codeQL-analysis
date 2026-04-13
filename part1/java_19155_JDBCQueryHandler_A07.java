import java.sql.*;

public class java_19155_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_19155_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String user = "username";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, user, password);

            String query = "SELECT * FROM Users";
            ResultSet result = handler.executeQuery(query);

            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                // process data
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}