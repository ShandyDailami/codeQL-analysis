import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_11006_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(".txt")) {
                    try {
                        System.out.println("Processing: " + file.getPath());
                        // add your security-sensitive operations here
                        // For example: read and print file contents
                        FileReader reader = new FileReader(file);
                        int data;
                        while ((data = reader.read()) != -1) {
                            System.out.print((char) data);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error processing file: " + file.getPath());
                    }
                }
            }
        }
    }
}