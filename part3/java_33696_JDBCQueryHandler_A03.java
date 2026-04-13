import java.sql.*;

public class java_33696_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection connection;

    public java_33696_JDBCQueryHandler_A03() {
        this.connection = this.createConnection();
    }

    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection");
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query");
            return null;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");
        try {
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error processing results");
        } finally {
            handler.closeConnection();
        }
    }
}