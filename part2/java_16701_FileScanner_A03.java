import java.io.File;
import java.util.Scanner;

public class java_16701_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

            for (File file : javaFiles) {
                System.out.println("Found .java file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}