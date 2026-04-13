import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34206_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The given directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The given path is not a directory");
            return;
        }

        System.out.println("Listing files in the directory: " + directoryPath);
        listFiles(directory, "");
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, indent + "  ");
            } else {
                System.out.println(indent + "- " + file.getName());
            }
        }
    }
}