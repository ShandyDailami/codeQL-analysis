import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40707_FileScanner_A01 {

    // Use recursion to list all files
    public static void listFiles(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File f : subFiles) {
                    listFiles(f);
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    // Use a Scanner to read a file
    public static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Use a FileScanner to list all txt files in a directory
    public static void listTxtFiles(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("path_to_file");
        File directory = new File("path_to_directory");

        // listFiles(file); // Uncomment this line to test the listFiles method
        // readFile(file); // Uncomment this line to test the readFile method
        listTxtFiles(directory); // Uncomment this line to test the listTxtFiles method
    }
}