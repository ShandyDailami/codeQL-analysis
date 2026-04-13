import java.sql.*;

public class java_09283_JDBCQueryHandler_A08 {
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            connectToDatabase();
            runQuery();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to the database");
    }

    private static void runQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
        while (resultSet.next()) {
            System.out.println("Row 1: " + resultSet.getString("column1") + " - " + resultSet.getString("column2"));
        }
    }

    private static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Connection closed");
        }
    }
}