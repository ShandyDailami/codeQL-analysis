import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_30370_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the extension to search for (e.g., '.txt'):");
        String extension = scanner.next();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        System.out.println("Searching for files with extension: " + extension);
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension.toLowerCase());
            }
        });

        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        Arrays.sort(files, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (File file : files) {
            System.out.println(file.getPath());
        }

        scanner.close();
    }
}