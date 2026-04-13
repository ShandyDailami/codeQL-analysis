import java.io.File;
import java.util.Scanner;

public class java_30226_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Process file here
                        System.out.println("File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        // Process directory here
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory");
            }
        } else {
            System.out.println("The specified directory does not exist");
        }
    }
}