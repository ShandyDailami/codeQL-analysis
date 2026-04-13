import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31473_JDBCQueryHandler_A07 {
    private final String url;
    private final String user;
    private final String password;

    public java_31473_JDBCQueryHandler_A07(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUsernameByPassword(String password) {
        String username = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement("SELECT username FROM Users WHERE password = ?");
            preparedStatement.setString(1, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                username = resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of declaration
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return username;
    }
}