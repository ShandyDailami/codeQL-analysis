import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18759_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory";

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIR_PATH);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Perform security-sensitive operations related to A07_AuthFailure
                            // For example, checking for username and password in a line
                            if (line.contains("username:password")) {
                                System.out.println("Found unauthorized access attempt in: " + file.getPath());
                            }
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Given path is not a directory.");
        }
    }
}