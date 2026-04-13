import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_07908_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory: ");
        String directory = scanner.next();
        System.out.print("Enter the file extension: ");
        String extension = scanner.next();

        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        if (listOfFiles != null) {
            Arrays.sort(listOfFiles, (o1, o2) -> {
                if (o1.isDirectory() && o2.isFile()) return -1;
                if (o2.isDirectory() && o1.isFile()) return 1;
                return o1.compareTo(o2);
            });

            for (File file : listOfFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}