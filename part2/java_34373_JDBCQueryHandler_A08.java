import java.sql.*;

public class java_34373_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_34373_JDBCQueryHandler_A08(String url, String username, String password) {
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

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of initialization
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        return null;
    }

    public void executeUpdate(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of initialization
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}