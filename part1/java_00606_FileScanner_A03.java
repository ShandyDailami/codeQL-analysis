import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00606_FileScanner_A03 {
    private static final String HIDDEN_FILE_PREFIX = ".";

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        FileFilter hiddenFileFilter = (File file) -> file.isHidden();

        File[] fileList = rootDirectory.listFiles(hiddenFileFilter);

        if (fileList == null) {
            System.out.println("No hidden files found in the current directory");
        } else {
            for (File file : fileList) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("\nContent of " + file.getName());
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File " + file.getName() + " not found");
                    }
                }
            }
        }
    }
}