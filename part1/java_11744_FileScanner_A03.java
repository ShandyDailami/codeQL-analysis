import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11744_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printDirectoryInfo(file);
                    File[] nestedFiles = file.listFiles();
                    if (nestedFiles != null) {
                        for (File nestedFile : nestedFiles) {
                            if (nestedFile.isFile()) {
                                printFileInfo(nestedFile);
                            } else if (nestedFile.isDirectory()) {
                                printDirectoryInfo(nestedFile);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printDirectoryInfo(File directory) {
        System.out.println("Directory: " + directory.getAbsolutePath());
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}