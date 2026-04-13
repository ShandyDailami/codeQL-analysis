import java.io.File;
import java.util.Scanner;

public class java_15150_FileScanner_A01 {

    private static final String ROOT_DIRECTORY = "C:\\"; // You can change this
    private static final String SEARCH_PATTERN = "*.txt"; // You can change this

    public static void main(String[] args) {
        File rootDir = new File(ROOT_DIRECTORY);
        startScanning(rootDir);
    }

    private static void startScanning(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    startScanning(f);
                } else {
                    if (f.getName().endsWith(SEARCH_PATTERN)) {
                        System.out.println("Found a file: " + f.getAbsolutePath());
                        // Here you can add the code to secure file access
                        // For example, you can read the file using a Scanner
                        try (Scanner scanner = new Scanner(f)) {
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (Exception e) {
                            System.out.println("Error occurred while reading the file: " + f.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}