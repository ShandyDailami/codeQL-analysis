import java.io.File;
import java.util.Scanner;

public class java_19900_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] authFailures = directory.listFiles((dir, name) -> name.matches(".*A07_AuthFailure.*"));

            if (authFailures != null) {
                for (File file : authFailures) {
                    if (file.delete()) {
                        System.out.println("Deleted file: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files matching pattern found in directory.");
            }
        } else {
            System.out.println("Given directory does not exist or is not a directory.");
        }

        scanner.close();
    }
}