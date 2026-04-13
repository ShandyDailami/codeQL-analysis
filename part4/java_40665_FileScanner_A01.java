import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_40665_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory!");
            System.exit(1);
        }

        System.out.println("The following .txt files are found in the directory:");
        System.out.println(Arrays.toString(txtFiles));
    }
}