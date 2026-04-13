import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_21244_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File startingDirectory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                // This filter will list only .java files
                return pathname.getName().endsWith(".java");
            }
        };

        listFiles(startingDirectory, fileFilter);
    }

    private static void listFiles(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, filter);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}