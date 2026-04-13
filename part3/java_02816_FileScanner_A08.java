import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02816_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File file = new File(filePath);

                if (file.delete()) {
                    System.out.println("Deleted file: " + filePath);
                } else {
                    System.out.println("Failed to delete file: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}