import java.io.File;
import java.util.Scanner;

public class java_04287_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }
}

class FileScanner {
    private File rootDirectory;

    public java_04287_FileScanner_A08() {
        rootDirectory = new File(".");
    }

    public void start() {
        scanDirectory(rootDirectory);
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(".java")) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}