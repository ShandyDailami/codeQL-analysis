import java.io.File;
import java.util.Scanner;

public class java_20021_FileScanner_A01 {
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
                        try {
                            System.out.println("Accessing file: " + file.getAbsolutePath());
                            // Removing the following line will break the code
                            // file.setReadable(false, false);
                            System.out.println("File access status: " + file.canRead());
                        } catch (SecurityException e) {
                            System.out.println("Access denied for file: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}