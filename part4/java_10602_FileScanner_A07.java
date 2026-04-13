import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10602_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        // Use the current directory
        File file = new File(".");

        // Use a Scanner to read the directory contents
        try (Scanner scanner = new Scanner(file.listFiles())) {
            while (scanner.hasNext()) {
                String fileName = scanner.nextLine();

                // Check if file is hidden (starts with '.'), if so, skip it
                if (fileName.charAt(0) == '.') {
                    continue;
                }

                // Check if file is executable (ends with 'x'), if so, skip it
                if (fileName.endsWith("x")) {
                    continue;
                }

                // Check if file is not in the user's home directory, if so, skip it
                if (fileName.startsWith(System.getProperty("user.dir"))) {
                    continue;
                }

                // Check if file is a directory, if so, skip it
                if (fileName.endsWith(File.separator)) {
                    continue;
                }

                System.out.println(fileName);
            }
        }
    }
}