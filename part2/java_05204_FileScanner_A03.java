import java.io.File;
import java.util.Scanner;

public class java_05204_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFile(file);
                }
            }
        }

        scanner.close();
    }

    private static void scanFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("password") || line.contains("secret") || line.contains("key")) {
                    System.out.println("Detected sensitive data in file: " + file.getPath());
                    return;
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}