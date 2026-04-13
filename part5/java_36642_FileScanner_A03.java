import java.io.File;
import java.util.Scanner;

public class java_36642_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if ("pdf".equalsIgnoreCase(extension)) {
                            System.out.println("File: " + file.getAbsolutePath() + " - Security: File is a PDF. Running injection code here...");
                            // Place injection code here
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}