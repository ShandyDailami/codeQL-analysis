import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02197_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory"; // Replace with your directory
    private static final String EXTENSION = ".txt"; // Replace with the file extension you are interested in

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY);
        printFilesWithExtension(directory, EXTENSION);
    }

    private static void printFilesWithExtension(File directory, String extension) throws FileNotFoundException {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    printFilesWithExtension(file, extension);
                }
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}