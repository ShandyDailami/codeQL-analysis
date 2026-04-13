import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25644_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.next();

        // Use the FileScanner class to scan the file for AuthFailure
        FileScanner fileScanner = new FileScanner();
        fileScanner.scan(new File(filePath), scanAuthFailure(fileScanner));
    }

    private static void scanAuthFailure(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("Authentication failure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class FileScanner {
        public void scan(File file, Runnable runnable) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("AuthFailure")) {
                        runnable.run();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}