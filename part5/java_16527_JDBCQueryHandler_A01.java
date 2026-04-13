import java.sql.*;

public class java_16527_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_16527_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL driver is present
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Record ID: " + resultSet.getString("id"));
                System.out.println("Record Name: " + resultSet.getString("name"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users WHERE id = " + args[0]); // assuming user id is passed as argument
    }
}