import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31340_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String directory = "path/to/directory"; // replace with your directory path
        File dir = new File(directory);

        // Scan for all files in the directory
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // process line here
                        // note: this is a placeholder for your security-sensitive operation
                        // for instance, check if a line contains a specific keyword
                        if (line.contains("auth_failure")) {
                            System.out.println("AuthFailure detected in: " + file.getPath());
                        }
                    }
                    scanner.close();
                }
            }
        }
    }
}