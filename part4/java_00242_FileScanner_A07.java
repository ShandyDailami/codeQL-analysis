import java.io.File;
import java.util.Scanner;

public class java_00242_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        try {
            File file = new File(path);
            File[] authFailureFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));

            if (authFailureFiles != null) {
                for (File authFailureFile : authFailureFiles) {
                    Scanner authFailureScanner = new Scanner(authFailureFile);
                    while (authFailureScanner.hasNextLine()) {
                        String line = authFailureScanner.nextLine();
                        if (line.contains("AuthFailure")) {
                            System.out.println("Found AuthFailure in: " + authFailureFile.getAbsolutePath());
                        }
                    }
                    authFailureScanner.close();
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning files.");
        }
    }
}