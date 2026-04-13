import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_23276_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in: " + directoryPath);
            printFilesWithExtension(directory, fileExtension);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void printFilesWithExtension(File directory, String extension) {
        File[] filesWithExtension = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        if (filesWithExtension != null) {
            Arrays.sort(filesWithExtension);
            for (File file : filesWithExtension) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with extension found in the directory.");
        }
    }
}