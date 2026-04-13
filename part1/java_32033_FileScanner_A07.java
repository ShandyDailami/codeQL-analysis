import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32033_FileScanner_A07 {

    public static void main(String[] args) {
        // Start scanning from the current directory
        String startDir = System.getProperty("user.dir");
        File startFile = new File(startDir);

        scanDirectory(startFile);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursion for directories
                    scanDirectory(file);
                } else {
                    // Checking for auth failure
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Replace 'authCheck' with your own authentication logic
                            if (line.contains("authCheck")) {
                                System.out.println("Auth failure detected in file: " + file.getAbsolutePath());
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}