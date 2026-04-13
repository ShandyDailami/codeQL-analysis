import java.sql.*;

public class java_35654_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM my_table";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            int column2 = resultSet.getInt("column2");
            // handle the data as needed
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}