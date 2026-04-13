import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_04784_FileScanner_A03 {
    public static void main(String[] args) {
        String searchString = "Injection";
        String filePath = "src/main/java/FileScanner.java";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path:");
        filePath = scanner.nextLine();

        System.out.println("Enter the search string:");
        searchString = scanner.nextLine();

        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Scanner fileScanner = new Scanner(path);
                int lineNumber = 0;
                while (fileScanner.hasNextLine()) {
                    lineNumber++;
                    String line = fileScanner.nextLine();
                    if (line.contains(searchString)) {
                        System.out.println("Line " + lineNumber + " contains the search string");
                    }
                }
                fileScanner.close();
            } else {
                System.out.println("File not found at " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}