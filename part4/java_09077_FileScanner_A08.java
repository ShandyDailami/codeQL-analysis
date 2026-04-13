import java.io.File;
import java.util.Scanner;

public class java_09077_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        scanner.close();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No .txt files found in the directory.");
        }
    }
}