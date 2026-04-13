import java.sql.*;

public class java_32316_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_32316_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query, Object[] parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeQuery();
    }

    public void executeUpdate(String query, Object[] parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        statement.executeUpdate();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(
                    "jdbc:mysql://localhost:3306/mydatabase", 
                    "username", 
                    "password");

            ResultSet result = handler.executeQuery(
                    "SELECT * FROM users WHERE name = ?",
                    new Object[]{"John"});

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

            handler.executeUpdate(
                    "UPDATE users SET password = ? WHERE name = ?",
                    new Object[]{"new_password", "John"});

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}