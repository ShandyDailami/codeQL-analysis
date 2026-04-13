import java.io.File;
import java.util.Scanner;

public class java_38621_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File("."); // Current directory

        // Use try-with-resources to clean up resources
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path (or '.' for current directory):");
            String path = scanner.nextLine();

            if (path.equals(".")) {
                dir = new File("."); // Current directory
            } else {
                dir = new File(path);
            }

            // If the path is valid, list the contents
            if (dir.exists()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        }
                    }
                } else {
                    System.out.println("No files or directories found in the given path");
                }
            } else {
                System.out.println("Invalid directory path");
            }
        }
    }
}