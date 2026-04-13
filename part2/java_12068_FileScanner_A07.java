import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12068_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/your/directory";

    public static void main(String[] args) {
        File directory = new File(DIR_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    File[] subFiles = file.listFiles();

                    if (subFiles != null) {
                        for (File subFile : subFiles) {
                            if (subFile.isFile()) {
                                printFileInfo(subFile);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");
    }
}