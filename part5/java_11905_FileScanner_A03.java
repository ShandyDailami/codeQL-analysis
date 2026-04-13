import java.io.*;

public class java_11905_FileScanner_A03 {

    private static final String SECRET_PATH = "C:/path/to/secret/files/";

    public static void main(String[] args) {
        File file = new File(SECRET_PATH);
        scanDirectory(file);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    try {
                        String fileName = file.getName();
                        if (isSecretFile(fileName)) {
                            System.out.println("Found a secret file: " + fileName);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean isSecretFile(String fileName) {
        return fileName.endsWith(".txt") || fileName.endsWith(".csv") || fileName.endsWith(".log");
    }
}