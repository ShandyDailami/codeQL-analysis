import java.io.File;
import java.util.Scanner;

public class java_29837_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

        if (javaFiles != null) {
            for (File file : javaFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No .java files found in the directory.");
        }

        scanner.close();
    }
}