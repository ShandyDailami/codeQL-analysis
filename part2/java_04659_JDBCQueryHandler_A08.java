import java.sql.*;

public class java_04659_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_04659_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
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

    public void executeUpdate(String update) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Use of a real URL, username, and password here is to show how to instantiate a JDBCQueryHandler object
        // Please replace them with your actual credentials.
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_url", "username", "password");

        // Run a simple query
        ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("your_column"));
        }

        // Run a simple update
        handler.executeUpdate("UPDATE your_table SET your_column = 'new_value' WHERE your_condition");
    }
}