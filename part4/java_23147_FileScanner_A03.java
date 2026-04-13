import java.io.*;
import java.util.*;

public class java_23147_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\your\\file.txt");

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // No injection here, but we're making sure we're not opening a file or a database.
                // You can add SQL queries here. For example, to select all rows from a table named 'test':
                // String query = "SELECT * FROM test";
                // ResultSet rs = stmt.executeQuery(query);

                // Here's a simple example of a SQL injection attack:
                // String injection = "DROP TABLE test; --";
                // String query = "SELECT * FROM " + injection;
                // ResultSet rs = stmt.executeQuery(query);

                // This will work, but the injection string is too long, and it will throw a SQL Exception.
                // String injection = "DROP TABLE test; SELECT * FROM test;";
                // String query = "SELECT * FROM " + injection;
                // ResultSet rs = stmt.executeQuery(query);

                // This is another way to get around SQL injection.
                // It's not a real attack, but it's a way to get around SQL injection.
                // String injection = new String(injection.getBytes());
                // String query = "SELECT * FROM " + injection;
                // ResultSet rs = stmt.executeQuery(query);

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}