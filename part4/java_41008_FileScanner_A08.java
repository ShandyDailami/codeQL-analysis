import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41008_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = scanner.nextLine();
                File file = new File(filePath);

                if (file.exists() && file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}