import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.Paths;

public class java_06301_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            FileSystem fs = FileSystems.getDefaultFileSystem();
            Path startingDir = Paths.get("./");  // replace with your directory
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the directory to scan:");
            String input = scanner.nextLine();

            if (input.endsWith("/")) {
                input = input.substring(0, input.length() - 1);
            }

            if (!(fs.provider().getSchemes().contains("file"))) {
                System.out.println("The program is not supported on this platform.");
                return;
            }

            Path dir = fs.getPath(input);

            if (!(fs.provider().getSchemes().contains("file"))) {
                System.out.println("The directory " + dir + " does not exist.");
                return;
            }

            System.out.println("Listing files in " + dir);
            boolean errorOccurred = false;
            for (File file : dir.iterator()) {
                if (file.isDirectory()) {
                    System.out.println("Error: " + file.getPath() + " is a directory.");
                    errorOccurred = true;
                } else {
                    System.out.println("File: " + file.getPath());
                }
            }

            if (!errorOccurred) {
                System.out.println("No errors occurred.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}