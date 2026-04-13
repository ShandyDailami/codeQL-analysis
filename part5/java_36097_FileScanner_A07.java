import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_36097_FileScanner_A07 {
    private static final String ROOT_DIR = "C:\\";

    public static void main(String[] args) {
        scanDirectory(new File(ROOT_DIR));
    }

    private static void scanDirectory(File directory) {
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Not a valid directory");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(VanillaFileScanner::scanFile);
        }
    }

    private static void scanFile(File file) {
        if (file.isFile()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    if (line.contains("A07_AuthFailure")) {
                        System.out.println("Found authentication failure in: " + file.getPath());
                    }
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("Error scanning file: " + file.getPath());
            }
        }
    }
}