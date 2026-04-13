import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17290_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        File directory = new File(directoryPath);

        try {
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File file = new File(filePath);

                // print file path
                System.out.println("File path: " + file.getPath());

                // print file name
                System.out.println("File name: " + file.getName());

                // print file size
                System.out.println("File size: " + file.length() + " bytes");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}