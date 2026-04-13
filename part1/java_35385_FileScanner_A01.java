import java.io.*;

public class java_35385_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        File dir = new File("."); // This is current directory
        scanDirectory(dir, "");
    }

    private static void scanDirectory(File dir, String indent) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    scanDirectory(file, indent + "  "); // Recursion
                } else {
                    System.out.println(indent + "File: " + file.getName());
                    // Adding security-sensitive operations here.
                    // For brevity, these operations are skipped for brevity.
                }
            }
        }
    }
}