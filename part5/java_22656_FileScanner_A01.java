import java.io.File;
import java.util.Scanner;

public class java_22656_FileScanner_A01 {

    private File file;

    public java_22656_FileScanner_A01(String filePath) {
        file = new File(filePath);
    }

    public void scan() {
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation, so we should not print it out
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("The file does not exist");
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/file");
        scanner.scan();
    }
}