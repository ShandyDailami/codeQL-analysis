import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_13571_FileScanner_A07 {
    private static final Set<String> restrictedExtensions = new HashSet<>(Arrays.asList(".exe", ".dll", ".pwn"));

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the directory path:");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Invalid directory path");
                return;
            }

            File[] files = directory.listFiles();
            if (files == null) {
                System.out.println("No files in directory");
                return;
            }

            for (File file : files) {
                if (file.isFile() && restrictedExtensions.contains(file.getPath().substring(file.getPath().lastIndexOf(".") + 1))) {
                    System.out.println("Restricted file found: " + file.getPath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}