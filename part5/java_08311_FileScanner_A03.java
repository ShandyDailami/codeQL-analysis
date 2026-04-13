import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_08311_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // Point this to the directory you want to scan
        String pattern = ".*\\.java"; // This is the pattern we want to match
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to scan:");
        String directoryPath = scanner.nextLine();
        try {
            directory = new File(directoryPath);
            findJavaFiles(directory, pattern);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }

    public static void findJavaFiles(File directory, String pattern) throws FileNotFoundException {
        File[] files = directory.listFiles((dir, name) -> name.matches(pattern));
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    System.out.println("Found Java file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findJavaFiles(file, pattern);
                }
            }
        }
    }
}