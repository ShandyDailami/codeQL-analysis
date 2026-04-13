import java.sql.*;

public class java_27364_JDBCQueryHandler_A08 {

    // Using a static MySQL server for simplicity
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_27364_JDBCQueryHandler_A08() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("field1"));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler();
        handler.performQuery("SELECT * FROM table1");
    }
}