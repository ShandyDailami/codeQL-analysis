import java.io.*;

public class java_30876_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }
}

class FileScanner {
    private File file;

    public java_30876_FileScanner_A08() {
        file = new File(".");
    }

    public void start() {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    printFileInfo(f);
                    deleteFile(f);
                }
            }
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Size: " + file.length() + " bytes");
    }

    private void deleteFile(File file) {
        System.out.println("Deleting file: " + file.getName());
        if (!file.delete()) {
            System.out.println("Failed to delete file: " + file.getName());
        }
    }
}