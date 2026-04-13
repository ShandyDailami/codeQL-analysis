import java.io.File;
import java.util.Scanner;

public class java_28126_FileScanner_A03 {
    private String path;

    public java_28126_FileScanner_A03(String path) {
        this.path = path;
    }

    public void scan() {
        File root = new File(this.path);
        scanDirectory(root);
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    processFile(file);
                }
            }
        }
    }

    private void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you could apply your security-sensitive operations. 
                // This is just a placeholder and won't do anything yet.
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Failed to process file: " + file.getPath());
        }
    }
}