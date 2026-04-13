import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31145_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] files = directory.list();

        // Ensure we don't accidentally access a file that's outside our scope
        if (files == null) {
            System.out.println("No files in this directory");
            return;
        }

        for (String file : files) {
            File f = new File(directory, file);

            // Verify that the file is a regular file
            if (f.isFile() && f.canRead()) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}