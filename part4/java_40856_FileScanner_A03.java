import java.io.File;
import java.util.Scanner;

public class java_40856_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File root = new File(path);
        scanFiles(root);

        scanner.close();
    }

    private static void scanFiles(File root) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFiles(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}