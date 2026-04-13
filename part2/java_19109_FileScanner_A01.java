import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19109_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        String fileExtension = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Perform security sensitive operation with the line
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}