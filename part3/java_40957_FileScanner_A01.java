import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_40957_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File startingDirectory = new File(directoryPath);

        FileFilter fileFilter = (File pathname) -> pathname.getName().equals(fileName);

        findFile(startingDirectory, fileFilter);
    }

    private static void findFile(File startingDirectory, FileFilter fileFilter) {
        if (startingDirectory.isDirectory()) {
            File[] files = startingDirectory.listFiles(fileFilter);
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        findFile(file, fileFilter);
                    } else {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Starting directory is not a directory");
        }
    }
}