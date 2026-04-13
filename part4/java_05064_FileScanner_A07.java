import java.io.File;
import java.util.Scanner;

public class java_05064_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
           
            // Calling a security-sensitive operation here
            enterSecurityCriticalOperation(f);

            }
        }
        scanner.close();
    }

    // Placeholder for security-sensitive operation
    public static void enterSecurityCriticalOperation(File file) {
        // Security-sensitive operation goes here
    }
}