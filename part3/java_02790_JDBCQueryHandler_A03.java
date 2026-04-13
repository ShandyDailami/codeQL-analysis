import java.sql.*;

public class java_02790_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_02790_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = null;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getString(1);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void executeUpdate(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}