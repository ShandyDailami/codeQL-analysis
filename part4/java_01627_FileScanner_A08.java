import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_01627_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(fileExtension);
            }
        });

        if (files != null) {
            Arrays.sort(files, (o1, o2) -> o1.getName().compareTo(o2.getName()));
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files found with the provided extension in the directory.");
        }
    }
}