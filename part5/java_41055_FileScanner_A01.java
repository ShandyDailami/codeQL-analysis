import java.io.File;
import java.io.IOException;

public class java_41055_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        // Create a file scanner for the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Process each file in the scanner
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println("File: " + file.getAbsolutePath());
        }

        // Close the scanner
        scanner.close();
    }

}

class FileScanner {

    private File file;

    public java_41055_FileScanner_A01(File file) {
        this.file = file;
    }

    public boolean hasNext() {
        return file.listFiles() != null;
    }

    public File nextFile() {
        File[] files = file.listFiles();
        if (files != null) {
            return files[0];
        }
        return null;
    }

    public void close() {
        // No action necessary in this case
    }

}