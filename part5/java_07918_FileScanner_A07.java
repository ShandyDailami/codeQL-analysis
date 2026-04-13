import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07918_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = "txt"; // replace with your file extension
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(directoryPath + "/" + fileName);

                if (file.exists() && file.isFile() && fileName.endsWith(extension)) {
                    System.out.println("File found: " + fileName);

                    // Here you can add the security-sensitive operation related to A07_AuthFailure

                } else {
                    System.out.println("File not found or not a text file: " + fileName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}