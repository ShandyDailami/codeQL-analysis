import java.io.File;
import java.util.concurrent.TimeUnit;

public class java_09042_FileScanner_A08 {
    public static void main(String[] args) {
        File currentDirectory = new File(".");

        System.out.println("Scanning current directory...");

        scanDirectory(currentDirectory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    // Add your security-sensitive operation here, e.g., checking file permissions
                    System.out.println("File: " + file.getPath());

                    try {
                        // Add your delay here
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}