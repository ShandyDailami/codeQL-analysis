import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19492_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to read file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}