import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10578_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "your_directory_path";
        String extension = "your_file_extension";

        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Place your security-sensitive operations here.
                        // This is just a placeholder.
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}