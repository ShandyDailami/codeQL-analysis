import java.sql.*;

public class java_02373_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_02373_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Print each column value
                System.out.println("Column 1: " + resultSet.getString("Column1"));
                System.out.println("Column 2: " + resultSet.getString("Column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connections
            if (resultSet != null) {
                try {
                    resultSet.close();
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
        return null;
    }
}