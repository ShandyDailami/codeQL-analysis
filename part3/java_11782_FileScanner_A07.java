import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11782_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String dirPath = scanner.nextLine();
            System.out.println("Enter the file extension:");
            String fileExt = scanner.nextLine();

            File directory = new File(dirPath);
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExt));

            if (files != null) {
                for (File file : files) {
                    // Assume that authenticationFailure() method is in AuthFailure class
                    AuthFailure authFailure = new AuthFailure(file);
                    if (authFailure.isAuthFailure()) {
                        System.out.println("Authentication failure found in file: " + file.getAbsolutePath());
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found!");
        }
    }
}