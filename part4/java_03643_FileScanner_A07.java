import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03643_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "auth_log.txt";
        String directoryPath = ".";

        File file = new File(directoryPath, fileName);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        } else {
            System.out.println("File not found: " + file.getPath());
        }
    }
}