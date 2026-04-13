import java.io.File;
import java.util.Scanner;

public class java_05260_FileScanner_A01 {

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        try {
                            System.out.println("Found a .java file: " + file.getPath());
                            // Secure operation: Reading file content
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                            scanner.close();
                        } catch (Exception e) {
                            System.out.println("Error while reading file: " + file.getPath());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Secure operation: Scanning current directory
        File currentDir = new File(".");
        scanDirectory(currentDir);
    }
}