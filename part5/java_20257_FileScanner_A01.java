import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class java_20257_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner for the directory
        FileScanner scanner = new FileScanner();

        // Get the directory path from user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = input.nextLine();

        // Iterate over all files in the directory
        Iterator<File> iterator = scanner.getAllFiles(new File(directoryPath));
        while (iterator.hasNext()) {
            File file = iterator.next();
            if (!file.canRead()) {
                System.out.println("Access to file " + file.getName() + " is denied!");
            } else {
                System.out.println("Access to file " + file.getName() + " is allowed!");
            }
        }
    }

    private static class FileScanner {

        public Iterator<File> getAllFiles(File directory) {
            // Use a real FileScanner implementation here
            // For now, we'll just return a stubbed out Iterator
            return new Iterator<File>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public File next() {
                    return null;
                }
            };
        }
    }
}