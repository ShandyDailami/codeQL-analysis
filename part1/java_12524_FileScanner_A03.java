import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_12524_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.next();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.next();

        File directory = new File(dirPath);

        if (directory.exists()) {
            System.out.println("Files in the directory: " + directory.list().length);
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith("." + fileExtension);
                }
            };
            String[] files = directory.list(filter);
            System.out.println("Files with the extension " + fileExtension + ": " + Arrays.toString(files));
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}