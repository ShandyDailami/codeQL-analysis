import java.io.File;
import java.util.Scanner;

public class java_31976_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File dir = new File(path);
        printFiles(dir);
    }

    private static void printFiles(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        // Add security-sensitive operations here.
        // For example, only print file name if file is not inaccessible or it has restricted permissions.
        System.out.println(file.getName());
    }
}