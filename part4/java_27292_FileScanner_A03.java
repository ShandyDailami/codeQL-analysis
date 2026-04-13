import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27292_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File file = new File(directoryPath);
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        String filePath = f.getPath();
                        System.out.println("File: " + filePath);
                        // Here, you should add your security-sensitive operations related to A03_Injection
                    } else if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getPath());
                        // Also, you should add your security-sensitive operations related to A03_Injection
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory: " + e.getMessage());
        }
    }
}