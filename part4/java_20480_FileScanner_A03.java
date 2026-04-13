import java.io.File;
import java.util.Scanner;

public class java_20480_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if ("pdf".equalsIgnoreCase(extension) || "txt".equalsIgnoreCase(extension)) {
                            System.out.println("File name: " + fileName);
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or it is not a directory.");
        }

        scanner.close();
    }
}