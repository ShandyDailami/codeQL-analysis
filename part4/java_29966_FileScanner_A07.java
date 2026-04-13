import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_29966_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        if (txtFiles == null) {
            System.out.println("No txt files found in the directory.");
            return;
        }

        System.out.println("Found " + txtFiles.length + " txt files:");
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }
    }
}