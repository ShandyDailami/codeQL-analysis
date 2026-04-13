import java.io.File;
import java.util.Scanner;

public class java_09973_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File file = new File(directoryPath);
        if (file.exists() && file.isDirectory()) {
            System.out.println("Directory exists.");
            File[] authFailureFiles = file.listFiles((dir, name) -> name.endsWith(".authFailure"));
            if (authFailureFiles != null) {
                for (File authFailureFile : authFailureFiles) {
                    try {
                        Scanner authFailureScanner = new Scanner(authFailureFile);
                        while (authFailureScanner.hasNextLine()) {
                            String line = authFailureScanner.nextLine();
                            if (line.contains("username") && line.contains("password")) {
                                System.out.println("AuthFailure detected in: " + authFailureFile.getPath());
                            }
                        }
                        authFailureScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error occurred while scanning file: " + authFailureFile.getPath());
                    }
                }
            } else {
                System.out.println("No .authFailure files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}