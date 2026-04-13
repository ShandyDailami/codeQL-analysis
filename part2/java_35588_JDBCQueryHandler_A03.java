import java.sql.*;

public class java_35588_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_35588_JDBCQueryHandler_A03(String url, String user, String password) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, RowCallbackHandler callback) {
        try {
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);
            // Handle the results
            resultSet.setFetchSize(50);
            resultSet.forEach(callback::processRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "root", "password");
        handler.executeQuery("SELECT * FROM users", resultSet -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + ": " + name);
        });
    }
}