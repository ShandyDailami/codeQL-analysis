import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_20363_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).filter(file -> file.isFile() && file.getName().endsWith(".txt")).forEach(file -> {
                    try {
                        AuthFailure authFailure = new AuthFailure(file);
                        if (authFailure.isSecure()) {
                            System.out.println("File: " + file.getName() + " is secure and password is " + authFailure.getPassword());
                        } else {
                            System.out.println("File: " + file.getName() + " is not secure");
                        }
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + file.getName());
                    }
                });
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}