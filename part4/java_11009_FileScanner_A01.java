import java.io.File;
import java.util.Scanner;

public class java_11009_FileScanner_A01 {
    private static final String SECRET_DIRECTORY = "path_to_your_secret_directory"; // Replace with your secret directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("You do not have permission to read the directory");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in directory");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            } else {
                System.out.println("File: " + file.getName());
           
                // In real-world application, you should avoid hardcoding the secret directory
                // Instead, use the directory path as an input to the security-sensitive function
                if (file.getAbsolutePath().startsWith(SECRET_DIRECTORY)) {
                    System.out.println("Access denied");
                    return;
                }
            }
        }
    }
}