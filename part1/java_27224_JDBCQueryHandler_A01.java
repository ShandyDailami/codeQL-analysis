import java.sql.*;

public class java_27224_JDBCQueryHandler_A01 {

    // BrokenAccessControl is assumed to be a class with methods for accessing a database.
    private BrokenAccessControl brokenAccessControl;

    public java_27224_JDBCQueryHandler_A01() {
        brokenAccessControl = new BrokenAccessControl();
    }

    public void performQuery(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = brokenAccessControl.getConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Handle the username and password here, for instance, you might log them
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT username, password FROM users");
    }
}