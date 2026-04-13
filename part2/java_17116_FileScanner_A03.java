import java.io.File;
import java.util.Scanner;

public class java_17116_FileScanner_A03 {
    public static void main(String[] args) {
        System.out.println("Please enter the path of the file to scan:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists() && file.canRead()) {
            scanFile(file);
        } else {
            System.out.println("The file does not exist or is not readable.");
        }
    }

    private static void scanFile(File file) {
        try {
            for (File subFile : file.listFiles()) {
                if (subFile.isDirectory()) {
                    scanFile(subFile);
                } else {
                    // Add code here to scan for injection attacks
                    // For example, you could use regular expressions or other string operations to detect specific patterns
                    // This is just a simple example and might not work for all files
                    if (subFile.getName().contains("injection")) {
                        System.out.println("File contains injection attempt: " + subFile.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getAbsolutePath());
        }
    }
}