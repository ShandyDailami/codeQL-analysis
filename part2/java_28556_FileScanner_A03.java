import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class java_28556_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file"); // replace with your file path
        Scanner scanner = new Scanner(file);

        String sql = "SELECT * FROM users WHERE username = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            statement = connection.prepareStatement(sql);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                statement.setString(1, line);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}