import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_03337_FileScanner_A01 {

    private static String directoryPath;
    private static String fileExtension;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        directoryPath = scanner.nextLine();

        System.out.println("Enter the file extension:");
        fileExtension = scanner.nextLine();

        scanDirectory(new File(directoryPath));
    }

    private static void scanDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(fileExtension)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        }
    }
}