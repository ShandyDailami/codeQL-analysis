import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35624_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Provide your directory path here
        String extension = ".txt"; // Provide the file extension here

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try {
                    Scanner scanner = new Scanner(txtFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Process the line here (e.g., print it)
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}