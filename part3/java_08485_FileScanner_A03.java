import java.io.File;
import java.util.Scanner;

public class java_08485_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the directory you want to scan:");
        String dirPath = scanner.nextLine();

        scanDir(dirPath);
    }

    private static void scanDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check if the file name contains suspicious characters
                    if (file.getName().contains("injection") || file.getName().contains("vulnerable")) {
                        System.out.println("Suspicious file: " + file.getName());
                    }
                } else {
                    // Recursively scan the directory
                    scanDir(file.getPath());
                }
            }
        }
    }
}