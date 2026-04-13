import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39755_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // create a scanner object for the user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // create a File object for the directory path
        File directory = new File(directoryPath);

        // use recursion to print all files in the directory
        printFiles(directory, "");
    }

    private static void printFiles(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indentation + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indentation + "Directory: " + file.getName());
                    printFiles(file, indentation + "  ");
                }
            }
        }
    }
}