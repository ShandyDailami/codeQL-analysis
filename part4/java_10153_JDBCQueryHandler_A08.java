import java.sql.*;

public class java_10153_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connectToDatabase();
            performQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private static void connectToDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    private static void performQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("columnName"));
        }
    }

    private static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}