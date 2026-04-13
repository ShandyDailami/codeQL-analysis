import java.sql.*;

public class java_07650_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_07650_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming you're using MySQL
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}