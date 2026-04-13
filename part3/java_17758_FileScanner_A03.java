import java.io.File;
import java.util.Scanner;

public class java_17758_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile() && file.canRead()) {
            scanFile(file);
        } else {
            System.out.println("Invalid file path or file does not exist.");
        }
    }

    private static void scanFile(File file) {
        try {
            // Create a new FileScanner to read the file
            FileScanner scanner = new FileScanner(file, "UTF-8");

            // Use the scanner to read the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can implement the security-sensitive operation, for example, checking for SQL injection
                // You can use a library like Velocity for SQL injection prevention
                // For example:
                // line = Velocity.execute(line);

                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}