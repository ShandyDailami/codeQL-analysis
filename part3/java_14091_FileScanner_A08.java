import java.io.*;

public class java_14091_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        scanDirectory(directory);
    }

    public static void scanDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    if (isSecuritySensitive(file)) {
                        System.out.println("File: " + file.getAbsolutePath() + " is security sensitive.");
                    }
                }
            }
        }
    }

    private static boolean isSecuritySensitive(File file) throws IOException {
        // Assume the file is security sensitive if it contains a sensitive keyword
        return file.getContent().contains("A08_IntegrityFailure");
    }
}