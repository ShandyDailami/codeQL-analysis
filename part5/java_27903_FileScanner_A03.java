import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27903_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "."; // replace with your directory path
        File directory = new File(directoryPath);

        printFileList(directory, "");
    }

    private static void printFileList(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && (file.canRead() && !file.getName().startsWith(".") && file.canExecute())) {
                    System.out.println(indent + file.getName());
                } else if (file.isDirectory()) {
                    printFileList(file, indent + "  ");
                }
            }
        }
    }
}