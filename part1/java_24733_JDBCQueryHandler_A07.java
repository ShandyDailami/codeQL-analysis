import java.sql.*;

public class java_24733_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_24733_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
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
        return resultSet;
    }

    public static void main(String[] args) {
        // You would typically have this in a separate configuration file
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        ResultSet resultSet = handler.executeQuery("SELECT * FROM mytable");

        // Process the ResultSet
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}