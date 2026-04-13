import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37869_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_your_directory"; // Replace with your directory path
        File directory = new File(directoryPath);
        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));
        
        if (javaFiles != null) {
            for (File file : javaFiles) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}