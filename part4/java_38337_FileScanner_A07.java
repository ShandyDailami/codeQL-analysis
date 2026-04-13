import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38337_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(0);
        }

        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(txtFilter);
        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getPath());
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }
    }
}