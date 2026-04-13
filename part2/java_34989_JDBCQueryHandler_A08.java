import java.sql.*;

public class java_34989_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_34989_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            processResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    private void processResultSet(ResultSet resultSet) throws SQLException {
        int columns = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(resultSet.getString(i) + " ");
            }
            System.out.println();
        }
    }
}