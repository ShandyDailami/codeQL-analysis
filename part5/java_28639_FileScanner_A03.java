import java.io.File;
import java.util.Scanner;

public class java_28639_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        processFile(file);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void processFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operations related to A03_Injection
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getName() + " - " + e.getMessage());
        }
    }
}