import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35552_FileScanner_A08 {

    private File file;

    public java_35552_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void scan() {
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        } else {
            System.out.println("File not found: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        MinimalistFileScanner scanner = new MinimalistFileScanner("src/main/resources/A08_IntegrityFailure.txt");
        scanner.scan();
    }
}