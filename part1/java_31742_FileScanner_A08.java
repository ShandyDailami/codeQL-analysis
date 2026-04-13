import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_31742_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("src/main/resources");
        List<File> files = getAllFiles(file);
        for (File f : files) {
            if (f.isFile()) {
                try {
                    Scanner scanner = new Scanner(f);
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                    scanner.close();
                    if (isContentSensitive(content)) {
                        System.out.println("File: " + f.getAbsolutePath() + " has content sensitivity");
                    }
                } catch (Exception e) {
                    System.out.println("Failed to read file: " + f.getAbsolutePath());
                }
            }
        }
    }

    private static List<File> getAllFiles(File directory) {
        List<File> files = new ArrayList<>();
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getAllFiles(file));
            }
        }
        return files;
    }

    private static boolean isContentSensitive(String content) {
        // Assume we are looking for common passwords or other sensitive data.
        // In a real-world situation, this would be more complex.
        return content.contains("password") || content.contains("secret") || content.contains("key");
    }
}