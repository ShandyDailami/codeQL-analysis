import java.io.File;
import java.util.Scanner;

public class java_14314_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String searchString = "search string";
        
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFile(file, searchString);
                }
            }
        }
    }

    private static void scanFile(File file, String searchString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("File: " + file.getName() + ", Line: " + (line.contains(searchString) ? "Found" : "Not Found"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}