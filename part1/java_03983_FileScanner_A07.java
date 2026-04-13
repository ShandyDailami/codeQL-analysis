import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03983_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File(".");
        String extension = "txt";
        String path = file.getAbsolutePath();

        System.out.println("Searching for files with extension: " + extension);
        System.out.println("Directory: " + path);

        findFiles(path, extension);
    }

    private static void findFiles(String directory, String extension) {
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println("File found: " + file.getName());
                } else if (file.isDirectory()) {
                    findFiles(file.getAbsolutePath(), extension);
                }
            }
        }
    }
}