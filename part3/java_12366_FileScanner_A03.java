import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_12366_FileScanner_A03 {
    private static int MAX_SIZE = 1024; // maximum file size in bytes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file extension you want to search for (like .txt):");
        String extension = scanner.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.length() <= MAX_SIZE && name.endsWith(extension);
            }
        });

        if (files != null) {
            Arrays.sort(files, (file1, file2) -> {
                if (file1.isDirectory() && file2.isFile()) {
                    return -1;
                } else if (file2.isDirectory() && file1.isFile()) {
                    return 1;
                } else {
                    return file1.getName().compareTo(file2.getName());
                }
            });

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with the specified extension and size found in the directory.");
        }
    }
}