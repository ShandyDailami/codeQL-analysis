import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16900_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Process the line here, such as sanitizing or validating data
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }
    }
}