import java.sql.*;

public class java_00009_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_00009_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveCustomers() {
        String query = "SELECT * FROM Customers";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Customer ID: " + resultSet.getInt("id"));
                System.out.println("Customer Name: " + resultSet.getString("name"));
                System.out.println("Customer Email: " + resultSet.getString("email"));
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        handler.retrieveCustomers();
    }
}