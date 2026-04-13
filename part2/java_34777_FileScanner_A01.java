import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.FileFilter;

public class java_34777_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "."; // The directory to be scanned
        String fileExtension = ".*\\.java$"; // The file extension to be scanned
        FileFilter filter = new java.io.FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                        File[] subfiles = file.listFiles(filter);
                        if (subfiles != null) {
                            for (File subfile : subfiles) {
                                if (subfile.isFile()) {
                                    printFileInfo(subfile);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        try {
            Scanner scanner = new Scanner(new FileReader(file));
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}