import java.io.File;
import java.util.Scanner;

public class java_29361_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Searching for files in directory: " + dirPath);

            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("Found file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + dirPath);
            }
        } else {
            System.out.println("Invalid directory: " + dirPath);
        }
    }
}