import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_35549_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        };

        printFiles(directory, filter);
    }

    private static void printFiles(File directory, FilenameFilter filter) {
        File[] list = directory.listFiles(filter);

        if (list == null) return;

        for (File file : list) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                printFiles(file, filter);
            }
        }
    }
}