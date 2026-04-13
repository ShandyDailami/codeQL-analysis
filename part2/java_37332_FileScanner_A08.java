import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37332_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory.");
            return;
        }

        System.out.println("Files with .txt extension: " + Arrays.toString(txtFiles));
    }
}