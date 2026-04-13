import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15628_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(fileExtension.toLowerCase());
            }
        };

        printFilesWithExtension(directory, fileFilter);
    }

    private static void printFilesWithExtension(File directory, FileFilter fileFilter) {
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        System.out.println(file.getAbsolutePath());
                    } catch (FileNotFoundException e) {
                        System.out.println("Error accessing file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    printFilesWithExtension(file, fileFilter);
                }
            }
        }
    }
}