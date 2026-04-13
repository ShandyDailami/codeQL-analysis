import java.io.File;
import java.util.Scanner;

public class java_32048_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File file = new File(dirPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Scanning files in: " + file.getAbsolutePath());
                scanFiles(file);
            } else {
                System.out.println("Not a directory: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }

        scanner.close();
    }

    private static void scanFiles(File file) {
        File[] listOfFiles = file.listFiles();
        for (File singleFile : listOfFiles) {
            if (singleFile.isFile()) {
                System.out.println("File found: " + singleFile.getName());
            } else if (singleFile.isDirectory()) {
                System.out.println("Directory found: " + singleFile.getName());
                scanFiles(singleFile);
            }
        }
    }
}