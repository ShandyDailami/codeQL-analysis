import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31670_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        String fileExtension = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);

                        // You can insert code here to handle the integrity failure
                        // for example, by validating the line or performing a secure operation
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}