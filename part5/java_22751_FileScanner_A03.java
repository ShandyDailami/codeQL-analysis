import java.io.*;

public class java_22751_FileScanner_A03 {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        File homeDirectory = new File(homeDir);

        FileScanner scanner = new FileScanner(homeDirectory);
        scanner.begin();

        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println("File: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Path: " + file.getPath());
            System.out.println("Parent path: " + file.getParent());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("---------------------------------");
        }

        scanner.end();
    }
}

class FileScanner {
    private File file;
    private File[] files;
    private int current;

    public java_22751_FileScanner_A03(File file) {
        this.file = file;
    }

    public void begin() {
        if (file.isDirectory()) {
            files = file.listFiles();
            current = 0;
        }
    }

    public boolean hasNext() {
        if (files == null) {
            return false;
        }

        // Skip directory entries
        if (files[current] == null || files[current].isDirectory()) {
            return hasNext();
        }

        return true;
    }

    public File nextFile() {
        return files[current++];
    }

    public void end() {
        // Nothing to do here
    }
}