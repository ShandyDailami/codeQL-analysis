import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16002_FileScanner_A07 {
    private File file;

    public java_16002_FileScanner_A07(File file) {
        this.file = file;
    }

    public void scan() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Found line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        AuthFailureScanner scanner = new AuthFailureScanner(file);
        scanner.scan();
    }
}