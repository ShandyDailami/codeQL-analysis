import java.io.File;
import java.util.Scanner;

public class java_20741_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in the directory:");
            for (File file : dir.listFiles()) {
                if (file.getName().endsWith(".txt")) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory or it does not exist!");
        }

        scanner.close();
    }
}