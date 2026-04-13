import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08733_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file you want to scan:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                scanFileForAuthFailure(file);
            } else if (file.isDirectory()) {
                scanDirectoryForAuthFailure(file);
            } else {
                System.out.println("Given path is not a valid file or directory.");
            }
        } else {
            System.out.println("Given file path does not exist.");
        }

        scanner.close();
    }

    private static void scanFileForAuthFailure(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lineNumber = 0;

        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();

            if (line.contains("authFailure")) {
                System.out.println("AuthFailure detected in line " + lineNumber);
            }
        }

        scanner.close();
    }

    private static void scanDirectoryForAuthFailure(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFileForAuthFailure(file);
                } else if (file.isDirectory()) {
                    scanDirectoryForAuthFailure(file);
                }
            }
        }
    }
}