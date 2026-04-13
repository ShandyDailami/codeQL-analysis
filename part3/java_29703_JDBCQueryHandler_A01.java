import java.sql.*;

public class java_29703_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_29703_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            // Replace with your own JDBC URL, user, and password
            String url = "jdbc:mysql://localhost:3306/mydb";
            String user = "myuser";
            String password = "mypassword";
            JDBCQueryHandler handler = new JDBCQueryHandler(url, user, password);

            ResultSet resultSet = handler.executeQuery("SELECT * FROM my_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("my_column"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}