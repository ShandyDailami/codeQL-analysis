import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07379_FileScanner_A08 {

    private static final String DIR_PATH = "/path/to/directory"; // replace with your directory path

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        if (dir.exists() && dir.isDirectory()) {
            try {
                Scanner scanner = new Scanner(new File(dir, "A08_IntegrityFailure.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }
    }
}