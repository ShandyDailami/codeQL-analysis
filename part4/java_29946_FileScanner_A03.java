import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_29946_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "C:\\temp"; // replace with your directory path
        String extension = ".txt";
        File directory = new File(dirPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            Set<String> safeFiles = new HashSet<>();
            Set<String> unsafeFiles = new HashSet<>();
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Here you would implement your own security check
                        // e.g., check if line contains any command for injection
                        if (line.contains("command")) {
                            unsafeFiles.add(file.getAbsolutePath());
                        } else {
                            safeFiles.add(file.getAbsolutePath());
                        }
                    }
                    scanner.close();
                }
            }

            System.out.println("Safe files: " + Arrays.toString(safeFiles.toArray()));
            System.out.println("Unsafe files: " + Arrays.toString(unsafeFiles.toArray()));
        }
    }
}