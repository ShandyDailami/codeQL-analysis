import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03468_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can add your security-sensitive operations. For example, check if a line contains a specific word.
                if (line.contains("your_word")) {
                    System.out.println("Access Denied!");
                    // Here you can implement your logic for access control. For example, lock the file.
                    file.setReadable(false, false);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}