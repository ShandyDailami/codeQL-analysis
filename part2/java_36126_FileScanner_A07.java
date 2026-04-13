import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36126_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/authFailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations with the line here.
                // For example, check if the line contains a certain username or password.
                if (line.contains("username") || line.contains("password")) {
                    System.out.println("AUTH FAILURE OCCURRED: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            e.printStackTrace();
        }
    }
}