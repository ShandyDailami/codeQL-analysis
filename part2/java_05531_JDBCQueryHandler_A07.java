import java.sql.*;

public class java_05531_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_05531_JDBCQueryHandler_A07(String url, String username, String password) {
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
                System.out.println("Result: " + resultSet.getString("columnName"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in executing the query: " + e.getMessage());
        }
    }
}