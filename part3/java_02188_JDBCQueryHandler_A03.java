import java.sql.*;

public class java_02188_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void disconnect() throws SQLException {
        if (this.connection != null && this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            throw new SQLException("Connection is closed.");
        }
        Statement statement = this.connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            throw new SQLException("Connection is closed.");
        }
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try {
            handler.connect();

            String query = "SELECT * FROM my_table";
            ResultSet resultSet = handler.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            handler.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}