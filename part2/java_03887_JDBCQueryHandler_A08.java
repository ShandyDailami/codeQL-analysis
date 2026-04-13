import java.sql.*;

public class java_03887_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_03887_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Here you can use the resultSet to process the data, but for this example we'll print it out
                System.out.println(resultSet.getString("Name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}