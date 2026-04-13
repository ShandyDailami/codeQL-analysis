import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01174_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String currentDirectory = new File(".").getAbsolutePath();
        printFilesInDirectory(currentDirectory);
    }

    private static void printFilesInDirectory(String directory) throws FileNotFoundException {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file.getAbsolutePath());
                }
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(file.getPath() + ": " + scanner.nextLine());
            }
            scanner.close();
        } else {
            System.out.println("Unable to read file: " + file.getPath());
        }
    }
}