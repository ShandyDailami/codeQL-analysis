import java.io.*;

public class java_30897_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");

        // Use recursive method to search all files and directories
        scanDirectory(file, "");
    }

    private static void scanDirectory(File dir, String indent) throws IOException {
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    // If file is directory, recursively call method
                    scanDirectory(file, indent + "    ");
                } else if (file.isFile()) {
                    // If file is a regular file, check if it's safe to read
                    if (isFileSafeToRead(file)) {
                        printFileInfo(file, indent + "    ");
                    }
                }
            }
        }
    }

    private static boolean isFileSafeToRead(File file) {
        // Implement security-sensitive operations here
        // For example, we can check if the file is write-protected
        return !file.canWrite();
    }

    private static void printFileInfo(File file, String indent) {
        System.out.println(indent + file.getName());
    }
}