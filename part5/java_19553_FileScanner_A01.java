import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_19553_FileScanner_A01 {

    // Security-sensitive operation: Only read file names
    public static String[] listFiles(File dir, final String ext, final FilenameFilter filter) {
        return dir.list(filter);
    }

    // Security-sensitive operation: Access and modification of file names
    public static void printFileNames(String[] files) {
        Arrays.stream(files).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory: ");
        String dir = scanner.next();
        System.out.print("Enter the file extension: ");
        String ext = scanner.next();

        File dirFile = new File(dir);

        // Security-sensitive operation: Access and modification of the directory
        if (!dirFile.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Security-sensitive operation: Access and modification of file names
        String[] files = listFiles(dirFile, "." + ext, null);
        printFileNames(files);
    }
}