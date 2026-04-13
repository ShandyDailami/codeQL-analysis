import java.io.File;
import java.util.Scanner;

public class java_05434_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (isInjectionSafe(file)) {
                            System.out.println("File: " + file.getAbsolutePath() + " is injection safe.");
                        } else {
                            System.out.println("File: " + file.getAbsolutePath() + " is NOT injection safe.");
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }

    private static boolean isInjectionSafe(File file) {
        String name = file.getName();
        // You can use any regular expression to check if a file name is safe.
        // For instance, a safe file name pattern could be ".*(sql|exe|pptx|docx|pdf|zip|rar).*$"
        // This pattern will match any file name ending with .sql, .exe, .pptx, .docx, .pdf, .zip, or .rar
        return name.matches(".*(sql|exe|pptx|docx|pdf|zip|rar).*$");
    }
}