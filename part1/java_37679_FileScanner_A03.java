import java.io.File;
import java.util.Scanner;

public class java_37679_FileScanner_A03 {
    private static final String DIRECTORY = "path_to_directory";

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    sanitizeAndPrintFileName(file);
                } else {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        }
    }

    private static void sanitizeAndPrintFileName(File file) {
        String name = file.getName();

        // Remove any dangerous characters from the file name.
        // This is a simple demonstration, real-world use cases may need more sophisticated handling.
        name = name.replace("<", "&lt;");
        name = name.replace(">", "&gt;");
        name = name.replace("(", "&lt;");
        name = name.replace(")", "&gt;");
        name = name.replace(";", "&semi;");
        name = name.replace("'", "&apos;");

        System.out.println(name);
    }
}