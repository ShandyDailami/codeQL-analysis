import java.io.*;

public class java_28358_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        FileScanner fileScanner = new FileScanner(file);
        fileScanner.scanFiles(true);
        fileScanner.printFileNames();
    }
}

class FileScanner {
    private File file;

    public java_28358_FileScanner_A01(File file) {
        this.file = file;
    }

    public void scanFiles(boolean recursive) {
        File[] foundFiles;
        if (recursive) {
            foundFiles = file.listFiles();
        } else {
            foundFiles = new File[]{file};
        }

        for (File file : foundFiles) {
            if (file.isFile()) {
                printFileInfo(file);
            } else if (file.isDirectory()) {
                scanFiles(true);
            }
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File: " + file.getPath());
    }

    public void printFileNames() {
        System.out.println("Here are the file names:");
        for (File file : file.listFiles()) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}