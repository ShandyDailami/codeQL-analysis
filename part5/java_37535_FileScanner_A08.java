import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37535_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(txtFilter);
        if (txtFiles == null) {
            System.out.println("No txt files found in the directory");
            return;
        }

        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }
}