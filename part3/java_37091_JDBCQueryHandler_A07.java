import java.sql.*;

public class java_37091_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_37091_JDBCQueryHandler_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", // Database URL
                    "username", // Database Username
                    "password"); // Database Password
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
        handler.closeConnection();
    }
}