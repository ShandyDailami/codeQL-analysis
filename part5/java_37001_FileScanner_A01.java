import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37001_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Given input is not a directory!");
            return;
        }

        System.out.println("Searching for files in: " + directoryPath);
        findFiles(directory, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
    }

    public static void findFiles(File directory, FilenameFilter filter) {
        File[] listFiles = directory.listFiles(filter);
        if (listFiles == null) return;

        for (File file : listFiles) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
                findFiles(file, filter);
            }
        }
    }
}