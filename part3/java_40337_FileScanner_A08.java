import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40337_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void listFiles(File directory, String indent) {
        for (int i = 0; i < indent.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + " ");
                } else {
                    System.out.print(indent + " ");
                    System.out.println(file.getName());
                }
            }
        }
    }
}