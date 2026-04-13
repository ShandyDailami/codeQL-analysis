import java.sql.*;

public class java_01054_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM A08_IntegrityFailure");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                if (checkIfRowUsedInForeignKey(id, connection)) {
                    System.out.println("Id: " + id + " is used in a foreign key constraint.");
                } else {
                    System.out.println("Id: " + id + " is safe to delete.");
                }
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIfRowUsedInForeignKey(String id, Connection connection) {
        boolean isUsed = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM A08_IntegrityFailure WHERE id='" + id + "'");

            while (resultSet.next()) {
                isUsed = true;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUsed;
    }
}