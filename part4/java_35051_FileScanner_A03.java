import java.io.File;
import java.util.Scanner;

public class java_35051_FileScanner_A03 {
    private static File file;
    private static String targetDirectory;
    private static String targetExtension;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        targetDirectory = scanner.nextLine();

        System.out.println("Enter the target extension:");
        targetExtension = "." + scanner.nextLine();

        file = new File(targetDirectory);

        scanFiles(file);
    }

    private static void scanFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(targetExtension)) {
                        // perform security-sensitive operations related to A03_Injection here
                        System.out.println("Found a file with extension: " + f.getName());
                    }
                    scanFiles(f);
                }
            }
        }
    }
}