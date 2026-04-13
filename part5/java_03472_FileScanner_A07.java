import java.io.File;
import java.util.Scanner;

public class java_03472_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            searchAuthFailures(directory);
        } else {
            System.out.println("The given path does not exist or is not a directory.");
        }
    }

    private static void searchAuthFailures(File directory) {
        File[] authFailFiles = directory.listFiles((dir, name) -> name.endsWith(".auth.fail"));

        if (authFailFiles != null) {
            for (File file : authFailFiles) {
                if (file.canRead()) {
                    System.out.println("Found an auth failure in file: " + file.getAbsolutePath());
                    // Add your security-sensitive operations here
                    // for example:
                    // try reading the file content
                    // verify the content
                    // if verification fails, print an error message
                } else {
                    System.out.println("The file " + file.getAbsolutePath() + " cannot be read.");
                }
            }
        } else {
            System.out.println("No auth failures files found in the directory.");
        }
    }
}