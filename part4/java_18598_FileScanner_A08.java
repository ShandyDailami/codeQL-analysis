import java.io.*;

public class java_18598_FileScanner_A08 {

    private static final String PATH = "/path/to/directory";  // replace with your directory

    public static void main(String[] args) {
        try {
            scanDirectory(new File(PATH));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void scanDirectory(File dir) throws Exception {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    // perform security-sensitive operations here
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) throws Exception {
        FileReader reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
            // perform security-sensitive operation here
        }
        reader.close();
    }
}