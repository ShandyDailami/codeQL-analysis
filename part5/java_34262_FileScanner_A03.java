import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34262_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // Capture the current directory
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if (!isSecuritySafe(file)) {
                        System.out.println("File found: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getName());
                }
            }
        }
    }

    private static boolean isSecuritySafe(File file) {
        // This is a simple example of checking if a file is a binary or shell script.
        // In a real application, you would need to use a more sophisticated method.
        String name = file.getName();
        return (name.endsWith(".sh") || name.endsWith(".exe"));
    }
}