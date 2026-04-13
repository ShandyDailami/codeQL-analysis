import java.io.File;
import java.util.Scanner;

public class java_00679_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                        if ("txt".equalsIgnoreCase(extension)) {
                            System.out.println("Text file found: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory found: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}