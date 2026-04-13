import java.io.File;
import java.util.Scanner;

public class java_09716_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getAbsolutePath());
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        if (f.isFile() && f.getName().endsWith(".java")) {
                            System.out.println("Security sensitive operation: Accessing file: " + f.getAbsolutePath());
                            // Assume the operation is checking the file for security sensitive operations
                            // This is a placeholder, actual implementation will depend on the specific requirements
                            checkFile(f);
                        }
                    }
                }
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found: " + path);
        }

        scanner.close();
    }

    private static void checkFile(File file) {
        // Implement security-sensitive operations here
        // For example, we'll just read the file for the sake of the example
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            // Handle exceptions as needed
        }
    }
}