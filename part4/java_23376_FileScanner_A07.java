import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_23376_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        System.out.println("Enter the file extension to search for (e.g., '.java'):");
        String ext = scanner.next();
        File dir = new File(dirPath);

        File[] matchingFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(ext);
            }
        });

        if (matchingFiles != null) {
            Arrays.sort(matchingFiles, new java.util.Comparator<File>() {
                public int compare(File f1, File f2) {
                    return f1.compareTo(f2);
                }
            });

            for (File file : matchingFiles) {
                System.out.println("File name: " + file.getName());
            }
        } else {
            System.out.println("No files found in the directory!");
        }

        scanner.close();
    }
}