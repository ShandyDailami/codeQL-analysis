import java.sql.*;

public class java_22283_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_22283_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
        ResultSet rs = handler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }
        handler.closeConnection();
    }
}