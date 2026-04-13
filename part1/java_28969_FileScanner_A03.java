import java.io.File;
import java.util.Scanner;

public class java_28969_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            fileSearch(dir, "");
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void fileSearch(File dir, String path) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileSearch(file, path + file.getName() + "/");
                } else {
                    System.out.println(path + file.getName());
                    // Security-sensitive operation related to A03_Injection.
                    // Example:
                    // System.out.println("Attempting to execute SQL injection: " + file.getAbsolutePath());
                }
            }
        }
    }
}