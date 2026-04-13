import java.sql.*;

public class java_37778_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // select all from table
            String selectAll = "SELECT * FROM mytable";
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // insert into table
            String insertIntoTable = "INSERT INTO mytable (name) VALUES ('John')";
            statement.executeUpdate(insertIntoTable);

            // update into table
            String updateTable = "UPDATE mytable SET name = 'Jack' WHERE id = 1";
            statement.executeUpdate(updateTable);

            // delete from table
            String deleteFromTable = "DELETE FROM mytable WHERE id = 2";
            statement.executeUpdate(deleteFromTable);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}