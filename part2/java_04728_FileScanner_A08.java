import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04728_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory path
        String fileExtension = ".txt"; // specify your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files with extension: " + fileExtension + " found in directory: " + directoryPath);
        }
    }
}