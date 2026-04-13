import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27698_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                File file = new File(directoryPath + "/" + scanner.nextLine());
                if (file.exists() && file.isFile() && file.canRead()) {
                    System.out.println("File: " + file.getPath());
                } else {
                    System.out.println("Error: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}