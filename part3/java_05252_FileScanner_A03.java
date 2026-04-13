import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05252_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isSqlCommand(line)) {
                    System.out.println("Detected SQL command: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSqlCommand(String line) {
        // Check if the line contains SQL commands such as SELECT, INSERT, UPDATE, DELETE, etc.
        // This is a very simplistic example and might not cover all possible SQL commands.
        return (line.toUpperCase().contains("SELECT") ||
                line.toUpperCase().contains("INSERT") ||
                line.toUpperCase().contains("UPDATE") ||
                line.toUpperCase().contains("DELETE"));
    }
}