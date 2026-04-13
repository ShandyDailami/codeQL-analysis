import java.sql.*;

public class java_27572_SessionManager_A08 {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            connectToDatabase();
            SessionManager sessionManager = new SessionManager();
            sessionManager.startSession();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
    }

    private void startSession() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM mytable";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Data from mytable: " + resultSet.getString("columnName"));
        }

        connection.close();
    }
}