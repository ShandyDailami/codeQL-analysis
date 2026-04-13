import java.sql.*;

public class java_12810_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_12810_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }

    public void disconnect() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            System.out.println("Disconnected from database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to disconnect from database");
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to execute query");
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int rowsUpdated = statement.executeUpdate(query);
            return rowsUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to execute update query");
        }
        return 0;
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        queryHandler.connect();
        ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        queryHandler.disconnect();
    }
}