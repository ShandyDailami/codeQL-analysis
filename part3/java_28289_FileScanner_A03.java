import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28289_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] txtFiles = dir.listFiles(txtFilter);
        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory");
            return;
        }

        System.out.println("The .txt files are:");
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getPath());
        }
    }
}