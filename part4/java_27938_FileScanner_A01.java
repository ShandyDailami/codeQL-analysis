import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27938_FileScanner_A01 {

    private String directoryPath;

    public java_27938_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scan() {
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();

                if (file.isHidden()) {
                    System.out.println("Hidden file found: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner("/path/to/directory");
        scanner.scan();
    }
}