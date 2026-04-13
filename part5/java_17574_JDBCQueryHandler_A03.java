import java.sql.*;

public class java_17574_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_17574_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString("column_name") + " ";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
       
        } finally {
            // Always close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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