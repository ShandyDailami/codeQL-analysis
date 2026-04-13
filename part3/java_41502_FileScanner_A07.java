import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41502_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String extension = ".txt";

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                scanFile(file);
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line in file: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}