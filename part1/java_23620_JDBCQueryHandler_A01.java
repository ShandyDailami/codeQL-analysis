import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class java_23620_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String passwordDB = password;

        try {
            Connection connection = DriverManager.getConnection(url, username, passwordDB);
            System.out.println("Connection established!");

            String query = "SELECT * FROM mytable WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Found a row with id 1");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
        }
    }
}