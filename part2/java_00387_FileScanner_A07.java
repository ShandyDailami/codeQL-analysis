import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00387_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner to scan the current directory
        FileScanner fileScanner = new FileScanner(new File("."));

        // Use a Scanner to read the input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a file extension
        System.out.print("Enter a file extension: ");
        String extension = scanner.next();

        // Filter the files by extension
        fileScanner.filter((file, path) -> file.getName().endsWith(extension));

        // Print all the files
        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.nextFile());
        }

        // Close the scanner
        scanner.close();
    }
}

class FileScanner {
    private final File[] files;
    private int current;

    public java_00387_FileScanner_A07(File directory) {
        this.files = directory.listFiles();
        this.current = 0;
    }

    public File nextFile() {
        return files[current++];
    }

    public boolean hasNext() {
        return current < files.length;
    }
}