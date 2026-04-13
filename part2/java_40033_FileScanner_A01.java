import java.io.File;
import java.util.Scanner;

public class java_40033_FileScanner_A01 {
    private static String targetDir;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target directory: ");
        targetDir = scanner.nextLine();

        File targetFile = new File(targetDir);

        if (!targetFile.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!targetFile.isDirectory()) {
            System.out.println("Provided path is not a directory");
            return;
        }

        scanFiles(targetFile);
    }

    private static void scanFiles(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Only scan files in the target directory
                    if (file.getPath().startsWith(targetDir)) {
                        System.out.println("File: " + file.getName());
                    }
                } else {
                    // Recursive call for subdirectories
                    scanFiles(file);
                }
            }
        }
    }
}