import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36748_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_36748_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}