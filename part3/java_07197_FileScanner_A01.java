import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07197_FileScanner_A01 {

    private static final String BROKEN_ACCESS_CONTROL_FOLDER = "/path/to/broken/access/control/folder";

    public static void main(String[] args) {
        File folder = new File(BROKEN_ACCESS_CONTROL_FOLDER);

        try (Scanner scanner = new Scanner(folder)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                File file = new File(folder.getAbsolutePath() + "/" + line);

                if (file.isFile()) {
                    System.out.println("Found a file: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Found a directory: " + file.getName());
                } else {
                    System.out.println("Unrecognized file type: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The directory does not exist: " + BROKEN_ACCESS_CONTROL_FOLDER);
        }
    }
}