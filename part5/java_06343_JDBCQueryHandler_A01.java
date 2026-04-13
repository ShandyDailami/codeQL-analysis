import java.sql.*;

public class java_06343_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_06343_JDBCQueryHandler_A01(String url, String username, String password) {
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
                System.out.println(resultSet.getString("username") + " " + resultSet.getString("password"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");
        jdbcQueryHandler.executeQuery("SELECT * FROM Users");
    }
}