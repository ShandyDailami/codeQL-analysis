import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_05018_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.next();
        System.out.println("Enter file extension:");
        String extension = scanner.next();

        File file = new File(path);
        File[] matchingFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (matchingFiles != null) {
            for (File f : matchingFiles) {
                System.out.println(f.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension " + extension);
        }
    }
}