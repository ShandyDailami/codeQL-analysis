import java.sql.*;

public class java_07001_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_07001_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC", "username", "password");
            this.statement = this.connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            result = this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int executeUpdate(String query) {
        int result = 0;
        try {
            result = this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        try {
            if (this.statement != null)
                this.statement.close();
            if (this.connection != null)
                this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}