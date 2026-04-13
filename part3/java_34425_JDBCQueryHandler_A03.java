import java.sql.*;

public class java_34425_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_34425_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
            ResultSet result = handler.executeQuery("SELECT * FROM users");

            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}