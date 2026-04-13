import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20462_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/your/directory"; // replace with your directory
        File directory = new File(directoryPath);
        scanDirectory(directory, "");
    }

    private static void scanDirectory(File directory, String indentation) {
        for (int i = 0; i < indentation.length(); i++) {
            System.out.print("-");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, indentation + "-");
            } else {
                printFile(file, indentation);
            }
        }
    }

    private static void printFile(File file, String indentation) {
        for (int i = 0; i < indentation.length(); i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
    }
}