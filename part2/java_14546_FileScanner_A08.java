import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14546_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object representing the directory you want to scan.
        File directory = new File("C:\\");

        // Use the listRoots() method of the File class to get a collection of
        // File objects representing all roots of the file system.
        File[] roots = directory.listRoots();

        // Iterate through the list of roots.
        for (File root : roots) {
            // Use the listFiles() method of the File object to get a collection of
            // File objects representing the files in the directory.
            File[] files = root.listFiles();

            // Iterate through the list of files.
            for (File file : files) {
                // Use the isDirectory() method of the File object to check if
                // a file is a directory.
                if (file.isFile()) {
                    // Use the getName() method of the File object to get the
                    // name of the file.
                    String filename = file.getName();

                    // Use the matches() method of the String class to check if
                    // the name of the file ends with ".txt".
                    if (filename.matches(".+\\.txt$")) {
                        // Use the Scanner class to read a file.
                        Scanner scanner = new Scanner(file);

                        // Use the next() method of the Scanner class to read
                        // the next token from the input.
                        while (scanner.hasNext()) {
                            // Use the nextLine() method of the Scanner class
                            // to read the next line from the input.
                            String line = scanner.nextLine();

                            // This is a placeholder for security-sensitive
                            // operations related to integrity failure.
                            // For example, we can print the line to the console:
                            System.out.println(line);
                        }

                        // Use the close() method of the Scanner class to close
                        // the scanner.
                        scanner.close();
                    }
                }
            }
        }
    }
}