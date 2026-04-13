import java.sql.*;

public class java_02952_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_02952_JDBCQueryHandler_A08(String url, String username, String password) {
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
                // Handle each result set row here.
                // For example, print out the values in a row.
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}