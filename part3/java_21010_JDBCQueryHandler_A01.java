import java.sql.*;

public class java_21010_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        connection.setAutoCommit(false);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // process result set
            System.out.println("User ID: " + resultSet.getInt("id"));
            System.out.println("User Name: " + resultSet.getString("name"));
            System.out.println("User Email: " + resultSet.getString("email"));
        }

        connection.commit();
        connection.close();
    }
}