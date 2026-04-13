import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33684_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory";
        String fileExtension = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                readFile(file);
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }
}