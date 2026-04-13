import java.io.File;
import java.util.Scanner;

public class java_06113_FileScanner_A08 {
    private static final String DIR = "C:\\path\\to\\your\\directory";
    private static final String EXTENSION = ".*\\.java$";

    public static void main(String[] args) {
        File dir = new File(DIR);
        if (dir.isDirectory()) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter file name (or 'quit' to exit):");
                while (scanner.hasNext()) {
                    String fileName = scanner.next();
                    if (fileName.equalsIgnoreCase("quit")) break;
                    File file = new File(dir, fileName);
                    if (file.exists() && file.isFile() && file.canRead()) {
                        scanForVulnerabilities(file);
                    } else {
                        System.out.println("File not found or access denied: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + DIR);
        }
    }

    private static void scanForVulnerabilities(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(EXTENSION)) {
                    System.out.println("Found a potential security vulnerability in: " + file.getAbsolutePath());
                    // Add your security analysis here.
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}