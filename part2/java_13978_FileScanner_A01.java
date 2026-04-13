import java.io.*;

public class java_13978_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your extension

        File directory = new File(directoryPath);

        FileScanner scanner = new FileScanner(directory, extension);

        scanner.start();
    }
}

class FileScanner {
    private File directory;
    private String extension;

    public java_13978_FileScanner_A01(File directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void start() {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}