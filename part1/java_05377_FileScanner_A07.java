import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05377_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            System.exit(1);
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            System.exit(1);
        }

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Accept all files
                return true;
            }
        };

        try {
            scanFilesInDirectory(directory, fileFilter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void scanFilesInDirectory(File directory, FileFilter fileFilter) throws FileNotFoundException {
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getAbsolutePath());
                    scanFilesInDirectory(file, fileFilter);
                }
            }
        }
    }
}