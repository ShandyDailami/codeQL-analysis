import java.io.File;
import java.util.Scanner;

public class java_30194_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String filePath = file.getAbsolutePath();
                        if (filePath.endsWith(".txt") || filePath.endsWith(".conf") || filePath.endsWith(".ini")) {
                            AuthFailureChecker checker = new AuthFailureChecker();
                            if (checker.isAuthFailure(filePath)) {
                                System.out.println("AuthFailure detected in: " + filePath);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
        scanner.close();
    }
}