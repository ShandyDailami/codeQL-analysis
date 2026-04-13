import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03872_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String searchString = "AuthFailure";
        String searchExtension = ".txt";

        System.out.println("Searching for files with the extension: " + searchExtension + " and the string: " + searchString);

        try {
            searchFiles(directory, searchString, searchExtension);
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getMessage());
        }
    }

    private static void searchFiles(File directory, String searchString, String searchExtension) throws FileNotFoundException {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(searchExtension)) {
                        if (searchInFile(file, searchString)) {
                            System.out.println("Found file: " + file.getPath());
                        }
                    }
                }
            }
        }
    }

    private static boolean searchInFile(File file, String searchString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    return true;
                }
            }
        }
        return false;
    }
}