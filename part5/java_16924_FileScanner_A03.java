import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_16924_FileScanner_A03 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] files = currentDir.list();

        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                File fileObj = new File(currentDir.getPath() + "/" + file);
                if (fileObj.isFile()) {
                    scanFile(fileObj);
                }
            }
        }
    }

    private static void scanFile(File file) {
        if (file.getName().endsWith(".txt")) {
            System.out.println("File: " + file.getAbsolutePath());
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Line: " + line);
                    // Secure operation related to A03_Injection
                    // For example, check for SQL injection here
                    // ...
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + file.getAbsolutePath());
            }
        }
    }
}