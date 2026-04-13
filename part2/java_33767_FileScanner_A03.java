import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33767_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".*"; // Replace with the actual file extension(s) you're scanning

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        // Use the line as needed, e.g., print it
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}