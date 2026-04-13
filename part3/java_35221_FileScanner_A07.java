import java.io.File;
import java.util.Scanner;

public class java_35221_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".java"));
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else {
                    System.out.println("File " + file.getAbsolutePath() + " is not accessible.");
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}