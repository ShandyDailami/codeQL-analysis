import java.io.File;
import java.util.Scanner;

public class java_01345_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/home/user/Documents/";
        String fileName = "sample.txt";

        File directory = new File(directoryPath);

        FileScanner scanner = new FileScanner(directory, fileName);

        while(scanner.hasNext()){
            File file = scanner.next();
            System.out.println("File found: " + file.getAbsolutePath());
        }

        scanner.close();
    }
}

class FileScanner {
    private File directory;
    private String fileName;
    private File[] files;
    private int currentFileIndex;

    public java_01345_FileScanner_A01(File directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
        this.currentFileIndex = -1;
    }

    public boolean hasNext() {
        if (this.currentFileIndex == -1) {
            this.files = this.directory.listFiles();
            this.currentFileIndex = 0;
        }

        return this.currentFileIndex < this.files.length;
    }

    public File next() {
        if (!this.hasNext()) {
            throw new RuntimeException("No more files in directory");
        }

        return this.files[this.currentFileIndex++];
    }

    public void close() {
        // Nothing to do here, as we don't have any external resources to close
    }
}