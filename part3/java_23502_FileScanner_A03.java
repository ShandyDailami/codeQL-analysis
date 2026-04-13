import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_23502_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        FilenameFilter txtFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(txtFilter);

        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory.");
            return;
        }

        System.out.println("Found the following .txt files:");
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getPath());
        }
    }
}