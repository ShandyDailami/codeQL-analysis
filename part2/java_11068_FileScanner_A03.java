import java.io.File;
import java.util.Scanner;

public class java_11068_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setFile(new File("target.txt")); // replace with your file
        scanner.scan();
    }

}

class FileScanner {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public void scan() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (containsInjectionAttempt(line)) {
                    System.out.println("Suspicious code found in: " + file.getPath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean containsInjectionAttempt(String line) {
        // This is a simple example of how to check for SQL injection. 
        // In a real application, you should use a more advanced method or library.
        return line.toLowerCase().contains("select") || line.toLowerCase().contains("insert")
                || line.toLowerCase().contains("update") || line.toLowerCase().contains("delete");
    }

}