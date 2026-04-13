import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34631_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "./src/main/resources";  // replace with your directory path
        File directory = new File(directoryPath);

        // Scan all text files in the directory
        for (File file : directory.listFiles((dir, name) -> name.endsWith(".txt"))) {
            try {
                // Use Scanner to read file content
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}