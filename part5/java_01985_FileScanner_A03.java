import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_01985_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter file extension:");
        String extension = scanner.nextLine();
        scanner.close();

        File dir = new File(path);
        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (listOfFiles != null) {
            Arrays.sort(listOfFiles, String.CASE_INSENSITIVE_ORDER);
            for (File file : listOfFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in directory " + dir.getAbsolutePath());
        }
    }
}