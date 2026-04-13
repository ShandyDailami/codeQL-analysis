import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34558_FileScanner_A03 {
    private static final String PATH = "/path/to/your/directory";

    public static void main(String[] args) {
        File directory = new File(PATH);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(directory.getPath() + "/" + fileName);

                if (file.isFile() && file.canRead()) {
                    processFile(file);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The directory does not exist or cannot be accessed.");
        }
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a simple example of a string formatting injection. 
                // In a real-world scenario, you would likely want to avoid this as it is unsafe.
                System.out.println(String.format("Processing line: %s", line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be read.");
        }
    }
}