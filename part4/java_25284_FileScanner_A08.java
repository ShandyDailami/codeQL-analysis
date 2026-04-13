import java.io.*;

public class java_25284_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "C:\\testdir";
        File root = new File(directory);

        scanDirectory(root);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    // Add code here to handle files.
                    // For example, read and print the file content.
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}