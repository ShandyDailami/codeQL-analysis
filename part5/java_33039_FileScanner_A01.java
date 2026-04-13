import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33039_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("."); // The current directory
        printDirectoryContents(directory);
    }

    public static void printDirectoryContents(File directory) {
        if (directory.listFiles() == null) {
            System.out.println("No files or directories found in " + directory.getAbsolutePath());
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                printFileContents(file);
            } else if (file.isDirectory()) {
                printDirectoryContents(file);
            }
        }
    }

    public static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file: " + file.getAbsolutePath());
        }
    }
}